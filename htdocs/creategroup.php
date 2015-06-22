<html>
	<head><title>Create Group</title></head>
	<body>
		<form>
			Enter Unique Group name<input type="text" name="gid">
			<input type="submit">
		</form>
		Select people to add to group<br>
		<?php
		require_once 'redirect.php';
		$result=$connection->query("select `name`,`roll_no` from `user`");
		if(!$result) echo "Query Error!!";
		
		for($i=0;$i<$result->num_rows;$i++)
		{
			$nmae=$result->fetch_row();
			echo "<div onclick=selector('$nmae[1]')>$nmae[0]</div>"."<br>"; //css color change
		}
		?>
		<div id="resp"></div>
		<script>
			
		function selector(name)
		{
			//x=document.getElementById("message_input");
			//params="check="+isThere;
			request = new ajaxRequest()
			request.open("POST", "groupCreate.php",true)
			request.setRequestHeader("Content-type","application/x-www-form-urlencoded")
			
			
			name="name="+name+"&gid=<?php echo $_GET['gid'];?>";
			
			request.send(name)
			//alert("<?php echo $_GET['gid'];?>");
			request.onreadystatechange = function()
			{
				//alert("alive1");
				if (this.readyState == 4)
				{
					//alert("alive2");
					if (this.status == 200)
					{
						//alert("alive3");
						if (this.responseText != null)
						{
							//alert("DONE");
							document.getElementById('resp').innerHTML =this.responseText
						}
						else alert("Ajax error: No data received")
					}
					else alert( "Ajax error: " + this.statusText)
				}
			}
				
		}
		//document.getElementById("here").innerHTML=x;
		//alert(x);
		//params = "url=localhost/aja.html"
		function ajaxRequest()
		{
			try
			{
				var request = new XMLHttpRequest()
			}
			catch(e1)
			{
				try
				{
					request = new ActiveXObject("Msxml2.XMLHTTP")
				}
				catch(e2)
				{
					try
					{		
						request = new ActiveXObject("Microsoft.XMLHTTP")
					}
					catch(e3)
					{	
						request = false
					}
				}
			}
			return request
		}
	</script>
	</body>
</html>