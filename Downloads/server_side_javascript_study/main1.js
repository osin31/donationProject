var http = require('http');
var fs = require('fs');
var url = require('url');
 
var app = http.createServer(function(request,response){
    var _url = request.url;
    var queryData = url.parse(_url, true).query;
    var pathname = url.parse(_url, true).pathname;
    if(pathname === '/'){
      if(queryData.id === undefined){
        //동기적 읽기
        //fs.readFileSync(`data/${queryData.id}`,'utf8')
        //비동기적 읽기 
        fs.readFile(`data/${queryData.id}`, 'utf8', function(err, description){
          var title = 'Welcome';
          var description = 'Node.js Test';
          var template = `
          <!doctype html>
          <html>
          <head>
            <title>${title}</title>
            <meta charset="utf-8">
          </head>
          <body>
          <h2>${title}</h2>
          <p>${description}</p>
            <ul>
              <li><a href="/?id=login">Login</a></li>
              <li><a href="/?id=sign">Sign</a></li>
            </ul>
          </body>
          </html>
          `;
          response.writeHead(200);
          response.end(template);
        });
      } else if(queryData.id=='login'){
        fs.readFile(`data/${queryData.id}`, 'utf8', function(err, description){
          var title = queryData.id;
          var template = `
          <!doctype html>
          <html>
          <head>
            <title>${title}</title>
            <meta charset="utf-8">
          </head>
          <body>
            <h1>${title}</h1>
            <ul>
              <p>Test Id  <input type="text" name="userId" placeholder="Id"/>  </p>
              <p>Test Pass<input type="password" name="passWord" placeholder="password"/>  </p>
            </ul>
          </body>
          </html>
          `;
          response.writeHead(200);
          response.end(template);
        });
      }
    } else if(queryData.id =='sign'){
     
    }
});
app.listen(3000);