function uploadImage(url) {
	  var width=270;
	  var height=350;
	  var from_top=350;
	  var from_left=500;
	  var toolbar='no';
	  var location='no';
	  var directories='no';
	  var status='no';
	  var menubar='no';
	  var scrollbars='no';
	  var resizable='no';
	  var atts='width='+width+'show,height='+height+',top='+from_top+',screenY=';
	  atts+= from_top+',left='+from_left+',screenX='+from_left+',toolbar='+toolbar;
	  atts+=',location='+location+',directories='+directories+',status='+status;
	  atts+=',menubar='+menubar+',scrollbars='+scrollbars+',resizable='+resizable;
	newwindow=window.open(url,'Uploading Image',atts);
	
	if (window.focus) {newwindow.focus();}
	return false;
}
document.getElementById("uploadBtn").onchange = function () {
    document.getElementById("uploadFile").value = this.value;
};
