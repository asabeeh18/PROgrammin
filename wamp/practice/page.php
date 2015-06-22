<html>
<head>
<title>Form Test</title>
</head>
<body>
<?php // formtest2.php
if (isset($_POST['name'])) $name = $_POST['name'];
else $name = "(Not entered)";
echo <<< _END

<html>
<body>
<form method="post" action="page.php">
What is your name?
<input type="text" name="name" placeholder='passme' required='required'>
<input type="submit">

Your name is: $name <br>
</form>
</body>
</html>
 _END;
?>
</body>
</html>
