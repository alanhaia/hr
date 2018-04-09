
function deleteHandle(eleId,url){
	var idInfo = "" ;
	var obj = document.all(eleId) ;
	if (obj.length == undefined){
		if(obj.checked){
			idInfo += obj.value + "@" ;
		} 
	} else {
		for(var x = 0 ; x < obj.length ; x ++){
			if(obj[x].checked){
				idInfo += obj[x].value + "@" ;
			}
		}
	}
	if (idInfo == ""){
		alert("您还没有选中要删除的数据！")
	} else {
		if (window.confirm("您确定要删除这些数据么？")){
			window.location = url + "?ids=" + idInfo;
		}
	}
}
function selectAll(eleId,selId){
	var obj = document.all(eleId) ;
	if(obj.length == undefined){
		obj.checked = document.getElementById(selId).checked ;
	} else {
		for(var x = 0 ; x < obj.length ; x ++){
			obj[x].checked = document.getElementById(selId).checked ;
		}
	}
}
function validateEmpty(eleName) {
	var obj = document.getElementById(eleName) ;
	if(obj.value == ""){
		obj.className = "wrong" ;
		return false ;
	} else {
		obj.className = "right" ;
		return true ;
	}
}
function validateRegex(eleName,regex) {
	var obj = document.getElementById(eleName) ;
	if (obj.value == ""){
		obj.className = "wrong" ;
		return false ;
	}else{
		if(regex.test(obj.value)){
			obj.className = "right" ;
			return true ;
		}else{
			obj.className = "wrong" ;
			return false ;
		}
	}
}
function gotime(){
	var mt = parseInt(document.getElementById("mytime").innerHTML) ;
	mt -- ;
	if(mt == 0){
		window.location = goUrl ;
	}else{
		document.getElementById("mytime").innerHTML = mt ;
		setTimeout(gotime,1000) ;
	}
}
