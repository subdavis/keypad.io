
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta
  name="viewport"
  content="user-scalable=no, initial-scale=1, maximum-scale=1, minimum-scale=1, width=device-width, height=device-height, target-densitydpi=device-dpi" />
<style type="text/css">
	p, .test { font-family: sans-serif; }
	.test {padding-top: 10px; padding-bottom: 10px; padding-left: 30px; padding-right: 30px; margin: 10px; width: 80px; line-height: 90px; border: 2px solid black; font-size: 3em; text-align: center; }
	full{padding-top: 10px; padding-bottom: 10px; padding-left: 30px; padding-right: 30px; height=100%;}
	.stats, .stats input { font-family: monospace; font-size: 0.9em; }
	input { width: 10em; }

	/* Disable certain interactions on touch devices */
	body { -webkit-touch-callout: none; -webkit-text-size-adjust: none; -webkit-user-select: none; -webkit-highlight: none; -webkit-tap-highlight-color: rgba(0,0,0,0); }
</style>
<script type="application/javascript" src="fastclick.js"></script>
<script type="application/javascript">
	window.addEventListener('load', function() {
		var testA, testB, teTime, cTime;
		
		<?php 
		foreach ($_GET as $key => $value) {
		if ($key == "UUID"){ }
		else{
		echo "var x" . $key .";\n";
		echo "x".$key . " = document.getElementById('".$key."');\n";
		echo "FastClick.attach(x".$key.");\n";
		}
		}
		?>
		
	}, false);
	
		var inputBox = document.getElementById("message");
		var output = document.getElementById("output");
		var form = document.getElementById("form");

		try {

			var host = "ws://rsmc.tk:9898/";
			console.log("Host:", host);
			
			var s = new WebSocket(host);
			s.onopen = function (e) {
				console.log("Socket opened.");
			};
			
			s.onclose = function (e) {
				console.log("Socket closed.");
			};
			
			s.onmessage = function (e) {
				console.log("Socket message:", e.data);
				var p = document.createElement("p");
				p.innerHTML = e.data;
				output.appendChild(p);
			};
			
			s.onerror = function (e) {
				console.log("Socket error:", e);
			};
			
		} catch (ex) {
			console.log("Socket exception:", ex);
		}
	
	</script>
</head>
<body>

	<div>
		<center>
		<?php
		
		foreach ($_GET as $key => $value) {
		static $x=0;
		if ($key == "UUID"){}
		else{
		if ((($x+1) % 2) == 0 || strlen($key) > 1) {echo "<br>";}
		echo "<span class=\"test\" id=\"" . $key . "\" onclick=\"s.send('0000." . $_GET["UUID"] .".". $key . "." . "1313')\"><full>" . $key . "</full></span>\n";
		}
		$x++;
		}
		?>
	</div>
</body>
</html>