<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Ajax</title>

<script type="text/javascript">
	function loadDoc() {
		var xmlhttp;
		if (window.XMLHttpRequest) {
			xmlhttp = new XMLHttpRequest();
		} else {
			xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
		}
		xmlhttp.onreadystatechange = function() {
			if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
				document.getElementById("myDiv").innerHTML = xmlhttp.responseText;
			}
		}
		/* xmlhttp.open("POST", "/musicApplication/ajax_test.html?t="
				+ Math.random(), false); */
		xmlhttp.open("POST", "/musicApplication/ajax_learn/ajax_test.html?t="
				+ Math.random(), true);
		/* xmlhttp.setRequestHeader("Content-type",
				"application/x-www-form-urlencoded"); */
		xmlhttp.send("fname=Henry&lname=Ford");
		document.getElementById("myDiv").innerHTML = xmlhttp.responseText;
	}

	function loadXMLDoc() {
		var xmlhttp;
		if (window.XMLHttpRequest) {
			xmlhttp = new XMLHttpRequest();
		} else {
			xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
		}
		xmlhttp.onreadystatechange = function() {
			if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
				myFunction(this);
			}
		}
		xmlhttp.open("POST", "/musicApplication/ajax_learn/cd_catalog.xml",
				true);
		xmlhttp.send();
	}

	function myFunction(xml) {
		var i;
		var xmlDoc = xml.responseXML;
		var table = "<table><tr><th>Artist</th><th>Title</th></tr>"
		var x = xmlDoc.getElementsByTagName("CD");
		for (i = 0; i < x.length; i++) {
			table = table
					+ "<tr><td>"
					+ x[i].getElementsByTagName("ARTIST")[0].childNodes[0].nodeValue
					+ "</td><td>"
					+ x[i].getElementsByTagName("TITLE")[0].childNodes[0].nodeValue
					+ "</td></tr>";
		}
		table = table + "</table>";
		document.getElementById("myDiv").innerHTML = table;
	}
</script>

</head>
<body>
	<h2>AJAX</h2>
	<button type="button" onclick="loadDoc()">修改内容</button>
	<button type="button" onclick="loadXMLDoc()">响应xml内容</button>
	<div id="myDiv"></div>
</body>
</html>