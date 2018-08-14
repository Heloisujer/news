<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<% String basePath = request.getScheme() + "://" + request.getServerName() + 
			":" + request.getServerPort() + request.getContextPath() + "/";%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <meta charset="UTF-8">
		<title>恐龙新闻主界面</title>
    <base href="<%=basePath%>">
    
		<link href="css/reset.css" rel="stylesheet">
		<link href="css/index.css" rel="stylesheet">
		<link href="css/iconfont.css" rel="stylesheet">
		<script src="js/jquery-1.9.1.min.js"></script>
		<script src="js/common.js"></script>
		<script src="js/index.js"></script>
	</head>
	<body>
		
	<div class="banner">   
		<div class="banner1">
        <ul>
            <li><img src="img/banner1.jpg" alt=""></li>
            <li><img src="img/banner2.jpg" alt=""></li>
            <li><img src="img/banner3.jpg" alt=""></li>
            <li><img src="img/banner1.jpg" alt=""></li>
        </ul>    	
    	</div>
    	<div class="bannerText">
       		<p class="bt1">dinosaur news</p>
       		<p class="bt2">恐龙新闻</p>
   		</div>   
    	<ul class="bannerBtn">
        	<li class="current"></li>
        	<li></li>
        	<li></li>
    	</ul>
    	<ul class="arrows">
    	   <li class="prev"><img src="img/left.png" alt=""></li>
      	  <li class="next"><img src="img/right.png" alt=""></li>
    	</ul>
    </div>
	<div class="mynews">
		 <h1>今日恐龙要闻</h1>
		<div class="mynews1">
			<div class="news-text">
			    <h2>虚假广告无底限 联防共治严把关</h2>
				<h3>“人无信不立”，诚信是社会主义核心价值观的重要一环，也是社会主义市场经济的重要保障。《新闻联播》从今天起推出系列报道《诚信建设万里行》，弘扬诚实守信的新风正气。今年上半年，各地不断加大力度整治虚假广告，查处各类虚假违法广告1.5万余件，罚没款9.2亿元。</h3>
			    <p>虚假广告 底限</p>
			    <span>2018-07-11 19:59</span>
			</div>
		</div>
		<div class="space"></div>
		<div class="mynews2">
			<div class="news-text">
			    <h2>晋江经验：世纪之初的探索和总结</h2>
				<h3>地处福建沿海的泉州晋江市，因为土地贫瘠，在改革开放之初，还是“一方水土难养一方人”的贫困农业县。如今这里已经成为全国民营经济最活跃的地区之一，连续17年跻身全国县域经济基本竞争力排行前十名。从今天开始，“壮阔东方潮 奋进新时代——庆祝改革开放40年”系列报道，将和您一起来解读晋江县域经济发展的成功“密码”。</h3>
			    <p>晋江经验 密码 人民日报</p>
			    <span>2018-07-11 19:549</span>
			</div>
		</div>
		<div class="space"></div>
		<div class="mynews3">
			<div class="news-text">
			    <h2>外媒称巴基斯坦借债务危机要挟中国提供贷款 中方：报道严重失实</h2>
				<h3>外媒称巴基斯坦借债务危机要挟中国提供贷款 中方：报道严重失实</h3>
			    <p>巴基斯坦 外债风险 贷款</p>
			    <span>2018-07-11 19:38</span>
			</div>
		</div>
	</div>
	</body>
</html>
