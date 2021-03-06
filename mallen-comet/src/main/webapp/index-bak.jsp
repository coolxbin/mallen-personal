<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html>
<% 
	String contextPath = request.getContextPath();
%>
<head>
    <meta http-equiv="Content-Type" content="text/html;charset=utf-8" />
    <script type="text/javascript" src="<%=contextPath %>/common/jquery/jquery-1.11.1/jquery-1.11.1.min.js"></script>
    <script type="text/javascript" src="<%=contextPath %>/org/cometd.js"></script>
    <script type="text/javascript" src="<%=contextPath %>/jquery/jquery.cometd.js"></script>
    <script type="text/javascript" src="application.js"></script>
    <%--
    The reason to use a JSP is that it is very easy to obtain server-side configuration
    information (such as the contextPath) and pass it to the JavaScript environment on the client.
    --%>
    <script type="text/javascript">
        var config = {
            contextPath: '<%=contextPath %>'
        };
    </script>
</head>
<body>

    <div id="body"></div>

</body>
</html>
