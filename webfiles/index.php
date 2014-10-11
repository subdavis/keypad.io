<?php 
include 'header.php'; 
echo $header;
?>
<h1>Flash Remote</h1>
<p>This is FlashRemote, a service that sets up instantly!<br>
<li>Send Keystrokes remotely from any computer / mobile device</li>
<li>Cross Platform - All you need is Java</li>
<li>Use a smartphone to advance PowerPoints!</li>
<h3>On PC / MAC</h3>
On the machine that will RECEIVE the keystrokes, Click <a href ="FlashRemote.jar">HERE to download</a> and run the JAR file.  You need Java 7 to run this.  Java is what keeps FlashRemote simple and flexible.
<h3>On Mobile</h3>
In any web browser, go to <b>rsmc.tk/socket</b>.  Start the desktop client first, and it will give you a UUID to enter below.<br>
</p>
<form action="client.php" method="post">
<table>
<tr>
<td>Desktop Client ID:</td><td> <input type="text" name="id"></td>
</tr>
<tr>
<td>Password:</td><td><input type="password" name="pass"></td>
</tr>
</table>
<br><br>
<b>Tick the keys you will need.</b><br><br>
<input type="checkbox" name="a" value="a" >a
<input type="checkbox" name="b" value="b" >b  
<input type="checkbox" name="c" value="c" >c  
<input type="checkbox" name="d" value="d" >d  
<input type="checkbox" name="e" value="e" >e  
<input type="checkbox" name="f" value="f" >f  
<input type="checkbox" name="g" value="g" >g  
<input type="checkbox" name="h" value="h" >h  
<input type="checkbox" name="i" value="i" >i  
<input type="checkbox" name="j" value="j" >j  
<input type="checkbox" name="k" value="k" >k  
<input type="checkbox" name="l" value="l" >l  
<input type="checkbox" name="m" value="m" >m <br>  
<input type="checkbox" name="n" value="n" >n 
<input type="checkbox" name="o" value="o" >o 
<input type="checkbox" name="p" value="p" >p  
<input type="checkbox" name="q" value="q" >q  
<input type="checkbox" name="r" value="r" >r  
<input type="checkbox" name="s" value="s" >s  
<input type="checkbox" name="t" value="t" >t  
<input type="checkbox" name="u" value="u" >u  
<input type="checkbox" name="v" value="v" >v  
<input type="checkbox" name="w" value="w" >w  
<input type="checkbox" name="x" value="x" >x  
<input type="checkbox" name="y" value="y" >y  
<input type="checkbox" name="z" value="z" >z<br>
<input type="checkbox" name="0" value="0" >0
<input type="checkbox" name="1" value="1" >1
<input type="checkbox" name="2" value="2" >2
<input type="checkbox" name="3" value="3" >3
<input type="checkbox" name="4" value="4" >4
<input type="checkbox" name="5" value="5" >5
<input type="checkbox" name="6" value="6" >6
<input type="checkbox" name="7" value="7" >7
<input type="checkbox" name="8" value="8" >8
<input type="checkbox" name="9" value="9" >9<br>
<input type="checkbox" name="left" value="left" >LEFT ARROW
<input type="checkbox" name="right" value="right" >RIGHT ARROW
<input type="checkbox" name="enter" value="enter" >ENTER
<input type="checkbox" name="backspace" value="backspace" >BACKSPACE
<input type="checkbox" name="space" value="space" >SPACE<br><br>
<input type='submit'>
</form>