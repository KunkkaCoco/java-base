<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="js/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
<script type="text/javascript">
	var activeNav = "${activeNav}";
	if(activeNav==""){
		activeNav = "navOverview";
	}	
	$("#"+activeNav).attr("class","active");
</script>
  </body>
</html>
