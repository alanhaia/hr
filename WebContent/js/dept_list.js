
window.onload = function(){
	document.getElementById("selall").addEventListener("click",function(){
		selectAll("celall","selall");
	},false);
	document.getElementById("rmBut").addEventListener("click",function(){
		deleteHandle("celall","dept_remove_do.jsp");
	},false);
}