<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<!DOCTYPE html>
<head>
	<title>Bar Graph</title>
</head>

<body >
	<div id="graphDiv1"></div>
	<br />
	<!-- <div id="graphDiv2"></div> -->
	<!--[if IE]><script src="excanvas.js"></script><![endif]-->
	<script src="http://localhost:8080/UniverClassroom/resources/html5-canvas-bar-graph.js"></script>
	<script>
	var values = new Array();
	var lables = new Array();
	var cnt = 5;
	function getValues(){ 
		/* alert(cnt);
		for(var i = 1; i < cnt; i++) {
			values.push(i);
		} */
		<% int array[] = (int[])request.getAttribute("values");%>
		var jsArray = new Array();
		<% for(int element:array){%>
		 jsArray[jsArray.length] = <%= element %>
		<% } %>
		<% String arrayName[] = (String[])request.getAttribute("lables");%>
		var examName = new Array();
		<% for(String element:arrayName){%>
		examName[examName.length] = '"<%= element %>"'
		<% } %>
		
		values = jsArray;
		lables = examName;
		
	}
	window.onpaint = getValues();
	(function () {
		
		function createCanvas(divName) {
			
			var div = document.getElementById(divName);
			var canvas = document.createElement('canvas');
			div.appendChild(canvas);
			if (typeof G_vmlCanvasManager != 'undefined') {
				canvas = G_vmlCanvasManager.initElement(canvas);
			}	
			var ctx = canvas.getContext("2d");
			return ctx;
		}
		
		var ctx = createCanvas("graphDiv1");
		
		var graph = new BarGraph(ctx);
		graph.maxValue = 100;
		graph.margin = 2;
		graph.colors = ["#49a0d8", "#d353a0", "#ffc527", "#df4c27"];
		//graph.xAxisLabelArr = ["North", "East", "West", "South"];
		graph.xAxisLabelArr = lables;
		/* setInterval(function () {
			graph.update([Math.random() * 30, Math.random() * 30, Math.random() * 30, Math.random() * 30]);
		}, 1000);
		 */
		  for(var i=0;values.lenght;i++){
			  alert("arr"+values[i]);
			  
			//graph.update([values[i]]);   
		 } 
		 //graph.update([3, 5, 3, 4]); 
		 graph.update(values); 
	//	graph.update([values[0],values[1]]);
		//graph.update([30,35]); 
		var ctx2 = createCanvas("graphDiv2");
		
		var graph2 = new BarGraph(ctx2);
		graph2.margin = 2;
		graph2.width = 450;
		graph2.height = 150;
		graph2.xAxisLabelArr = ["A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M"];
		setInterval(function () {
			graph2.update([Math.random() * 20, Math.random() * 20, Math.random() * 20, Math.random() * 20, Math.random() * 20, Math.random() * 20, Math.random() * 20, Math.random() * 20, Math.random() * 20, Math.random() * 20, Math.random() * 20, Math.random() * 20, Math.random() * 20]);
		}, 1500);

	}());</script>
</body>
</html>