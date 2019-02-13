var express = require('express');
var fs = require('fs');//파일을 읽어들이는 내부모듈
var oracledb = require('oracledb');
var dbConfig = require('./dbconfig.js');
oracledb.autoCommit = true;
var app = express();
var conn;

oracledb.getConnection({
  user:dbConfig.user,
  password:dbConfig.password,
  connectString:dbConfig.connectString //oracle설치할때 지정한 이름(파일명으로 확인가능)
},function(err,con){
  if(err){
    console.log("접속이 실패했습니다.",err);
  }
  conn = con;
});
app.get('/',function(req,res){
  fs.readFile('main.html',function(error,data){
    res.writeHead(200,{'Content-Type':'text/html'});
    console.log("main data::"+data)
    res.end(data);
  });
});
app.get('/page',function(req,res){
  fs.readFile('page.html',function(error,data){
    res.writeHead(200,{'Content-Type':'text/html'});
    console.log("error::"+error);
    console.log("data::"+data);
    res.end(data);
  });
});
app.get('/main',function(error,data){
  fs.readFile('main.html',function(error,data){
    res.writeHead(200,{'Content-Type':'text/html'});
    console.log("data::"+data);
    res.end(data);
  });
});
app.get('/sign',function(error,data){
  fs.readFile('sign.html',function(error,data){
    res.writeHead(200,{'Content-Type':'text/html'});
    console.log("data::"+data);
    res.end(data);
  })
});
app.post('/insertSign',function(request,response){
  console.log(request.body);
  var writer = request.body.writer;
  var title = request.body.title;
  var content = request.body.content;

    conn.excute("insert into sign(no,id,pass)values(no_seq.nextval,'"+id+"','"+password+"')"),function(err,result){

      if(err){
        console.log("등록중 에러가 발생", err);
        response.writeHead(500, {"ContentType":"text/html"});
        response.end("fail!!");
    }else{
        console.log("result : ",result);
        response.writeHead(200, {"ContentType":"text/html"});
        response.end("success!!");
    }
    }
})
app.listen(3303,function(){
  console.log('server start');
})