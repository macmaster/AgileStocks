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
	for(var idx = 0; idx < checkboxes.length; idx++){
		checkboxes[idx].checked = true;
	}
	
}