module.exports = {
    user          : process.env.NODE_ORACLEDB_USER || "node",
    password      : process.env.NODE_ORACLEDB_PASSWORD || "node",
    connectString : process.env.NODE_ORACLEDB_CONNECTIONSTRING || "localhost/XE",
    externalAuth  : process.env.NODE_ORACLEDB_EXTERNALAUTH ? true : false
  };

  var oracledb = require('oracledb');
var dbConfig = require('./dbconfig.js');

oracledb.getConnection(
  {
    user          : "node",
    password      : "node",
    connectString : "localhost/XE"
  },
  function(err, connection)
  {
    if (err) {
      console.error(err.message);
      return;
    }
    connection.execute(      
	"select issue_yymm, epc_code, remark, tag_location_seq,  reg_date from tag_issue WHERE rownum < :did",
      [50],
      function(err, result)
      {
        if (err) {
          console.error(err.message);
          doRelease(connection);
          return;
        }
        console.log(result.metaData);
        console.log(result.rows);
        doRelease(connection);
      });
  });

function doRelease(connection)
{
  connection.release(
    function(err) {
      if (err) {
        console.error(err.message);
      }
    });
}