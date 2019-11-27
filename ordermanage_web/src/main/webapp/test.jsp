
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>jQuery fSelect Plugin Demo</title>
    <link href='http://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css'>
    <link href="fSelect.css" rel="stylesheet" type="text/css">
    <link rel="stylesheet" type="text/css" href="../demo.css">
    <style>
        body { font-family:'Open Sans';}
        .container { margin:10px auto; max-width:640px;}
    </style>
</head>

<body>
<h1 class="logo"><a href="http://www.freejs.net" title="freejs首页"><img src="../../images/logo.png" height="47" width="500" alt="freejs首页" /></a></h1>
<div id="main_demo">
    <div align="center">
        <h2><a href="../../article_biaodan_524.html">select 下拉框多选，用select代替checkbox</a></h2></div>
    <div align="center" style="padding:20px;"><script type="text/javascript"><!--
    google_ad_client = "pub-4490194096475053";
    /* 728x90, 创建于 08-12-8 */
    google_ad_slot = "0403648181";
    google_ad_width = 728;
    google_ad_height = 90;
    //-->
    </script>
        <script type="text/javascript"
                src="http://pagead2.googlesyndication.com/pagead/show_ads.js">
        </script></div>
    <div class="container">
        <select class="demo" multiple="multiple">
            <optgroup label="Languages">
                <option value="cp">C++</option>
                <option value="cs">C#</option>
                <option value="oc">Object C</option>
                <option value="c">C</option>
            </optgroup>
            <optgroup label="Scripts">
                <option value="js">JavaScript</option>
                <option value="php">PHP</option>
                <option value="asp">ASP</option>
                <option value="jsp">JSP</option>
            </optgroup>
        </select>
    </div>
    <script src="http://code.jquery.com/jquery-1.11.3.min.js"></script>
    <script src="fSelect.js"></script>
    <script>
        $(function() {
            $('.demo').fSelect();
        });
    </script>
</div>

</body>
</html>
