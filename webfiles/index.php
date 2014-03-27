<?php 
include 'header.php'; 
echo $header;
?>
<p>Please download the client and start it up.  You will be given a 4 digit UUID to enter here so our server knows where to send your keystrokes.<br>
<form action="client.php" method="post">
Desktop Client UUID <input type="text" name="UUID"><br>
<input type='submit'>

<?php 
include 'footer.php'; 
echo $footer;
?>