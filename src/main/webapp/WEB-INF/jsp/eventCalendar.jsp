<!doctype html>
<head>
	<meta http-equiv="Content-type" content="text/html; charset=utf-8">
	<title>Mini calendar in the lightbox</title>

	<script src="http://localhost:8080/SchoolTrackAdminPanel/resources/codebase/dhtmlxscheduler.js" type="text/javascript" charset="utf-8"></script>
	<link rel="stylesheet" href="http://localhost:8080/SchoolTrackAdminPanel/resources/codebase/dhtmlxscheduler.css" type="text/css" media="screen" title="no title"
	      charset="utf-8">

	<script src="http://localhost:8080/SchoolTrackAdminPanel/resources/codebase/ext/dhtmlxscheduler_minical.js" type="text/javascript" charset="utf-8"></script>

	<style type="text/css" media="screen">
		html, body {
			margin: 0px;
			padding: 0px;
			height: 100%;
			overflow: hidden;
		}
	</style>

	<script type="text/javascript" charset="utf-8">

		function init() {
			scheduler.config.multi_day = true;

			scheduler.config.event_duration = 35;

			scheduler.config.xml_date = "%Y-%m-%d %H:%i";
			scheduler.init('scheduler_here', new Date(2015, 0, 10), "week");
			scheduler.load("./data/events.xml", function() {
				scheduler.showLightbox(3);
			});

			scheduler.config.lightbox.sections = [
				{ name:"description", height:200, map_to:"text", type:"textarea" , focus:true },
				{ name:"time", height:72, type:"calendar_time", map_to:"auto" }
			];

		}

	</script>
</head>
<body onload="init();">
<div id="scheduler_here" class="dhx_cal_container" style='width:100%; height:100%;'>
	<div class="dhx_cal_navline">
		<div class="dhx_cal_prev_button">&nbsp;</div>
		<div class="dhx_cal_next_button">&nbsp;</div>
		<div class="dhx_cal_today_button"></div>
		<div class="dhx_cal_date"></div>
		<div class="dhx_cal_tab" name="day_tab" style="right:204px;"></div>
		<div class="dhx_cal_tab" name="week_tab" style="right:140px;"></div>
		<div class="dhx_cal_tab" name="month_tab" style="right:76px;"></div>
	</div>
	<div class="dhx_cal_header">
	</div>
	<div class="dhx_cal_data">
	</div>
</div>
</body>