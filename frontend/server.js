var express = require("express");
var path = require("path");
var app = express();

app.use(express.static(__dirname));

app.get("/", function (request, response) {
    console.log(__dirname);
    response.sendFile(path.join(__dirname + "/movie.html"));
});

app.get("/movie", function (request, response) {
    console.log("soooo does it even go into movie or");
    response.sendFile(path.join(__dirname + "/movie.html"));
});

app.listen(1337);
console.log("Server started on port 1337");