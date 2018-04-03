var express = require("express");
var path = require("path");
var app = express();

app.use(express.static(__dirname));

app.get("*", function (request, response) {
    response.sendFile(path.join(__dirname + "/index.html"));
});

app.listen(1337);
console.log("Server started on port 1337");