/** script.js *************************************************
 * Manage the interactivity, animation, and fx for 
 * ronny.ml homepage.
 * 
 * Author: Ronald Macmaster
 * Date: 5/30/16
 *************************************************************/

function helloWorld(){
	console.log("Hello World!");
}

function toggleAll(){
	checkboxes = document.getElementsByName("querys");
	save = document.getElementById("save");
	ticker = document.getElementById("stock");
	login = document.getElementById("login");
	for(var idx = 0; idx < checkboxes.length; idx++){
		checkboxes[idx].checked = true;
	}
	login.action = "stock/" + ticker.value;
	save.value = "true";
}

function regularSubmit(){
	ticker = document.getElementById("stock");
	login = document.getElementById("login");
	login.action = "stock/" + ticker.value;
}