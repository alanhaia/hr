window.onload = function(){
	document.getElementById("deptno").addEventListener("blur",validateDeptno,false) ;
	document.getElementById("dname").addEventListener("blur",validateDname,false) ;
	document.getElementById("loc").addEventListener("blur",validateLoc,false) ;
	document.getElementById("myForm").addEventListener("submit",function(e){
		if(!(validateDeptno() & validateDname() & validateLoc())){
			e.preventDefault() ;
		}
	},false) ;
}
function validateDeptno(){
	return validateRegex("deptno",/^\d{2}$/) ;
}
function validateDname(){
	return validateEmpty("dname") ;
}
function validateLoc(){
	return validateEmpty("loc") ;
}