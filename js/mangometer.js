function generateMangoes() {
	var ratings = document.getElementsByClassName("rating");
	console.log(ratings);

		
	for(var i = 0; i < ratings.length; i++) {	
		var mangoes = Math.round((ratings[i].getAttribute("name"))/20);
		var ratingDiv = ratings[i];
		console.log("index " + i);
		for (var j = 0; j < 5 - mangoes; j++) {
			ratingDiv.innerHTML = "<img src='images/mangobw.png'>" + ratingDiv.innerHTML;
		}
		
		for (var j = 0; j < mangoes; j++) {
			ratingDiv.innerHTML = "<img src='images/mangocolor.png'>" + ratingDiv.innerHTML;
		}
		console.log("exited");
	}
	console.log("aaa");
}