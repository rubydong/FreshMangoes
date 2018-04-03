var express = require("express");
var path = require("path");
var app = express();

app.use(express.static(__dirname));

app.get("/", function (request, response) {
    response.sendFile(path.join(__dirname + "/index.html"));
});

app.get("/movie/", function (request, response) {
    console.log("movie");
    response.sendFile(path.join(__dirname + "/index.html"));
});

app.get("/movie/:id", function (request, response) {
    console.log("movie/" + request.params.id + " here");
    response.sendFile(path.join(__dirname + "/index.html"));
});

// app.get("*", function (request, response) {
//     console.log("did not match with anything at all in node");
//     response.sendFile(path.join(__dirname + "/index.html"));
// });

app.listen(1337);
console.log("Server started on port 1337");