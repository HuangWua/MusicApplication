<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style>
* {
	box-sizing: border-box;
	-webkit-box-sizing: border-box;
	-moz-box-sizing: border-box;
}

body {
	font-family: Helvetica;
	-webkit-font-smoothing: antialiased;
	background: rgba(71, 147, 227, 1);
}

.top {
	margin: 10px 70px 50px;
	box-shadow: 0px 35px 40px rgba(0, 0, 0, 0.2);
}

.top-bar {
	text-align: center;
	text-transform: uppercase;
	letter-spacing: 1px;
	color: white;
	border-radius: 5px;
	font-weight: normal;
	border: none;
	border-collapse: collapse;
	width: 100%;
	max-width: 100%;
	white-space: nowrap;
	/* 	background-color: white; */
}

.logo {
	float: left;
	background: #333;
	padding: 2px 20px;
}

ul {
	height:75px;
    list-style-type: none;
    margin: 0;
    padding: 0;
    overflow: hidden;
    background-color: #333;
}

li {
    float: left;
    height: 100%;
    text-align: center;
}

li a {
	height: 100%;
    display: block;
    color: white;
    text-align: center;
    padding: 25px 15px;
    text-decoration: none;
    text-transform: none;
}

li a:hover:not(.active) {
    background-color: #111;
}

.active {
	text-align:center;
	font-size:10px;
    background-color: #4CAF50;
    height: 100%;
    padding-top: 28px;
}

/* Table Styles */
.table-wrapper {
	margin: 10px 70px 40px;
	box-shadow: 0px 35px 50px rgba(0, 0, 0, 0.2);
}

.fl-table {
	border-radius: 5px;
	font-size: 12px;
	font-weight: normal;
	border: none;
	border-collapse: collapse;
	width: 100%;
	max-width: 100%;
	white-space: nowrap;
	background-color: white;
}

.fl-table td, .fl-table th {
	text-align: center;
	padding: 6px 8px;
}

.fl-table td {
	border-right: 1px solid #f8f8f8;
	font-size: 12px;
}

.fl-table thead th {
	color: #ffffff;
	background: #4FC3A1;
}

.fl-table thead th:nth-child(odd) {
	color: #ffffff;
	background: #324960;
}

.fl-table tr:nth-child(even) {
	background: #F8F8F8;
}

/* Responsive */
/* @media ( max-width : 767px) {
	.fl-table {
		display: block;
		width: 100%;
	}
	.table-wrapper:before {
		content: "Scroll horizontally >";
		display: block;
		text-align: right;
		font-size: 11px;
		color: white;
		padding: 0 0 10px;
	}
	.fl-table thead, .fl-table tbody, .fl-table thead th {
		display: block;
	}
	.fl-table thead th:last-child {
		border-bottom: none;
	}
	.fl-table thead {
		float: left;
	}
	.fl-table tbody {
		width: auto;
		position: relative;
		overflow-x: auto;
	}
	.fl-table td, .fl-table th {
		padding: 20px .625em .625em .625em;
		height: 60px;
		vertical-align: middle;
		box-sizing: border-box;
		overflow-x: hidden;
		overflow-y: auto;
		width: 120px;
		font-size: 13px;
		text-overflow: ellipsis;
	}
	.fl-table thead th {
		text-align: left;
		border-bottom: 1px solid #f7f7f9;
	}
	.fl-table tbody tr {
		display: table-cell;
	}
	.fl-table tbody tr:nth-child(odd) {
		background: none;
	}
	.fl-table tr:nth-child(even) {
		background: transparent;
	}
	.fl-table tr td:nth-child(odd) {
		background: #F8F8F8;
		border-right: 1px solid #E6E4E4;
	}
	.fl-table tr td:nth-child(even) {
		border-right: 1px solid #E6E4E4;
	}
	.fl-table tbody td {
		display: block;
		text-align: center;
	} */
	
#selectname{
	margin: 28px 5px;
}
	
.operate{
	padding: 2px;
	margin: 0px 12px;
}
.download{
	background: blue;
	color: white;
}
.playmusic{
	background: green;
	color: white;
}

}
</style>

<link href="https://cdn.bootcss.com/aplayer/1.10.1/APlayer.min.css"
	rel="stylesheet">
<script src="https://cdn.bootcss.com/aplayer/1.10.1/APlayer.min.js"></script>
<script type="text/javascript" src='${pageContext.request.contextPath }/resource/js/jquery-3.4.1.min.js'></script>

</head>
<body>

	<div class="top">
		<div class="top-bar">
			<div id="logo" class="logo">
				<div style="margin: 2px">
					<img width="52px" height="52px"
						src="${pageContext.request.contextPath }/resource/images/logo.jpg">
				</div>
				<span style="font-size: 12px">某某音乐</span>
			</div>
			<ul>
				<li><a href="#home">播放音乐</a></li>
				<li><a href="#news">上传音乐</a></li>
				<li><a href="#news">后台管理</a></li>
				<li><a href="#contact">....</a></li>

				<li><input type="text" id="selectname" name="name"
					placeholder="输入歌名查询" /> <input type="button" name="doselect"
					value="搜索" /></li>

				<li style="float: right"><c:if
						test="${sessionScope.adminname!=null }">
						<a class="active" href="#about">${sessionScope.adminname }</a>
					</c:if> <c:if test="${sessionScope.adminname==null}">
						<a class="active" href="#about">登入</a>
					</c:if></li>
			</ul>
		</div>
	</div>
	<div class="table-wrapper">
		<table class="fl-table">
			<thead>
				<tr>
					<th onclick="sort('音乐标题')">音乐标题</th>
					<th>风格</th>
					<th>歌手</th>
					<th>歌曲简介</th>
					<th>操作</th>
				</tr>
			</thead>
			<tbody id="tbody">
				<tr>
					<td width="25%">1</td>
					<td width="15%">Content</td>
					<td>Content</td>
					<td><a>Content</a></td>
					<td width="18%">
						<div class="operate">
							<input type='button' class='playmusic' value='播放'
								onclick='playmusic(value.id)' /> <input type='button'
								class='download' value='下载' onclick='download(value.id)' />
						</div>
					</td>
				</tr>
			</tbody>
		</table>
	</div>

	<div
		style="width: 100%; position: fixed; bottom: 0px; text-align: center; padding: 0px 100px">
		<div id="player">
			<pre class="aplayer-lrc-content">
				
			</pre>
		</div>
	</div>

</body>

<script type="text/javascript">

	function play(data){
		if(data!=null){
			alert(data[0].al.picUrl+","+data[0].id+","+data[0].name+","+data[0].al.name);
			$.get("https://v1.itooi.cn/netease/search?keyword=演员&type=song",
			function(data){
				
			});
		}
		var ap = new APlayer({
		container : document.getElementById('player'),
		lrcType : 1,
		autoplay : true,
		audio : {
				name : data==null?"":data[0].name,
				artist : data==null?"":data[0].ar[0].name,
				url : data==null?"":"https://v1.itooi.cn/netease/url?id="+data[0].id,
				cover : data==null?"":data[0].al.picUrl
			}
		});
	
	}
	
	$("div#player").click(function(){
		$.get("https://v1.itooi.cn/netease/song?id=421160836",
			function(data){
			play(data.data.songs);
		});
	});

	function showData(list){
		var s="<tbody id='tbody'>"
		$("#tbody").remove();
		$.each(list,function(n,value){
			s=s+"<tr><td width='25%''>"+value.name
			+"</td><td width='15%'>"+value.typename
			+"</td><td>"+value.singername
			+"</td><td>"+(value.detail==null?"暂无简介":value.detail)
			+"</td><td width='18%'><div class='operate'>"
			+"<input type='button' class='playmusic' value='播放' onclick='playmusic("+value.id
			+")'/><input type='button' class='download' value='下载' onclick='download("+value.id
			+")'/></div></td></tr>";
			});
			s=s+"</tbody>"
		$(".fl-table").append(s);
			
		/* $.each(list,function(n,val){
			$.each(val,function(n,value){
				s="<tr><td width='25%''>"+value.name
				+"</td><td width='15%'>"+value.typename
				+"</td><td>"+value.singername
				+"</td><td>"+(value.detail==null?"暂无简介":value.detail)
				+"</td><td width='18%'><div class='operate'>"
				+"<input type='button' class='playmusic' value='播放' onclick='playmusic("+value.id
				+")'/><input type='button' class='download' value='下载' onclick='download("+value.id
				+")'/></div></td></tr>";
				$("#tbody").append(s);
			});
		}); */
	}
	
	var playing;
	
	
	function playmusic(id) {
		$.post("findMusicsById.action", {
			id : id
		}, function(data) {
			playing=data;
			$.get(data.url,function(data1){
				play(data1.data.songs);
			});
		}); 
	} 

	function download(id) {
		alert("download" + id+playing.name);
		if(id==playing.id){
			var a = document.createElement('a');
			/* a.setAttribute('download','');  */
			
			a.download=playing.name+".mp3";
			a.href=playing.url;
			a.click();
		}
	} 
	

	function sort(sortname) {
		alert(sortname);
	}
	
	$(document).ready(function() {
		var selectData = new Array;
		var list = ${musicList};
		showData(list);
		play(null);
		$("input[name='doselect']").click(function(){
			var selectname=$('#selectname').val();
			$.post("selectMusicsByName.action",{name:selectname},function(data){
				if(data.length>0){
					showData(data);
				}else{
					alert("未搜索带该歌曲");
				}
			});
		});
		/* $("") */
	});
	
</script>

</html>
