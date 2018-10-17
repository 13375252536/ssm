<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>国家创新创业政策信息服务网</title>
	<meta name="keywords" content="双创政策查询,双创,创新,创业,创新创业,双创政策,国家双创政策,国家双创政策查询,双创活动周,创响中国,示范基地,国家示范基地,双创头条,双创税收查询">
	<meta name="description" content="国家创新创业政策信息服务网由国家发展和改革委员会主办，国家信息中心及下属单位负责运行维护，整合共享国务院和国务院各部门，以及各省、自治区、直辖市人民政府等相关职能部门发布的创新创业信息，现开通“头条资讯、政策库、政策分析、示范基地、活动跟踪、服务拓展、建言献策”等栏目，权威统一发布创新创业政策、动态、活动、服务等信息，建设政府与公众互动交流新渠道。">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	<meta name="renderer" content="webkit">
	<meta charset="utf-8">
	<link rel="stylesheet" href="/css/base.css">
	<link rel="stylesheet" href="/css/yzhStyle.css">
	<link rel="stylesheet" href="/css/common.css">
	<script type="text/javascript" src="/js/jquery-1.8.3.min.js"></script>
	<script type="text/javascript" src="/js/tongji.js"></script>
	<script type="text/javascript" src="/js/headerFooter.js"></script>
	<script type="text/javascript" src="/js/imgHandle.js"></script>
	<script type="text/javascript" src="/js/index.js"></script>
</head>
<body>

<!-- 轮播图开始 -->
<div class="slider-container">
	<ul class="slider-body" id="index-slider-body"></ul>
	<div class="up_focus" id="index-focus"></div>
	<div class="prev" id="index-prev"><img src="/imgs/i_prev.png"></div>
	<div class="next" id="index-next"><img src="/imgs/i_next.png"></div>
	<div class="bottom-bg" id="index-title-ul"></div>
</div>
<%--双创动态--%>
<div class="center">
	<div class="main-container">
		<div class="scdt-container">
			<div class="top">
					<%--部委--%>
					<div class="buwei">
						<div class="dt-title">
							<div class="label">
								<div class="img-wrapper"><img src="/imgs/buwei.png"></div>
								<label>部委</label>
							</div>
							<a href="" class="more-link">更多<div class="img-wrapper"><img src="/imgs/more_icon.png"></div></a>
						</div>
						<ul class="buwei-list" id="buwei-list"></ul>
					</div>
					<%--热门--%>
					<div class="shoulu">
						<div class="title">
							<div class="img-wrapper"><img src="/imgs/shoulu_icon.png"></div>
							<label>热门</label>
						</div>
						<div class="shoulu-container" style="height: 311px;" id="shoulu-container"></div>
					</div>
			</div>
			<div class="bottom">
				<ul class="container">
					<%--地方--%>
					<li class="dongtai-bottom-item">
						<div class="dt-title">
							<div class="label">
								<div class="img-wrapper"><img src="/imgs/difang.png"></div>
								<label>地方</label>
							</div>
							<a href="" class="more-link">更多<div class="img-wrapper"><img src="/imgs/more_icon.png"></div></a>
						</div>
						<ul class="dongtai-bottom-item-list" id="difang-list"></ul>
					</li>
					<%--社会团体--%>
						<li class="dongtai-bottom-item">
							<div class="dt-title">
								<div class="label">
									<div class="img-wrapper"><img src="/imgs/tuanti.png"></div>
									<label>社会团体</label>
								</div>
								<a href="" class="more-link">更多<div class="img-wrapper"><img src="/imgs/more_icon.png"></div></a>
							</div>
							<ul class="dongtai-bottom-item-list" id="shtt-list"></ul>
						</li>
					<%--基地--%>
						<li class="dongtai-bottom-item">
							<div class="dt-title">
								<div class="label">
									<div class="img-wrapper"><img src="/imgs/jidi.png"></div>
									<label>基地</label>
								</div>
								<a href="dongTaiList.html?type=2" class="more-link">更多<div class="img-wrapper"><img src="/imgs/more_icon.png"></div></a>
							</div>
							<ul class="dongtai-bottom-item-list" id="jidi-list"></ul>
						</li>
				</ul>
			</div>
			<%--双创专题专栏--%>
			<div class="sczt-container">
				<div class="index-public-title">
					<a href="javascript:;">专题专栏</a>
				</div>
				<div class="content">
					<div class="left">
						<div class="img-wrapper"><a href=""><img src="/imgs/zhuanti1.png"></a></div>
						<ul class="zhuanti1-list" id="qcg-index"></ul>
					</div>
					<div class="right">
						<div class="img-wrapper"><a href=""><img src="/imgs/zhuanti2.png"></a></div>
						<ul class="zhuanti1-list" id="zxx-index"></ul>
					</div>
				</div>
			</div>
			<%--最新政策 政策分析部分--%>
			<div class="zc-fx-container">
				<!-- 最新政策开始 -->
				<div class="zc-container">
					<div class="index-public-title">
						<a href="">最新政策</a>
					</div>
					<div class="title">
						<div class="tab-btn-wrapper">
							<div class="tab-btn active" id="xinzheng-buwei">部委
							</div><div class="tab-btn" id="xinzheng-difang">地方</div>
						</div>
						<a href="" class="more-link" id="zxzc-more-link">更多<div class="img-wrapper"><img src="/imgs/more_icon.png"></div></a>
					</div>
					<ul class="xinzheng-list" id="xinzheng-list">

					</ul>
				</div>
				<!-- 最新政策结束 -->
				<!-- 政策分析开始 -->
				<div class="fx-container">
					<div class="index-public-title">
						<a href="">政策分析</a>
					</div>
					<div class="title-wrapper">
						<div class="title">月度政策热点</div>
					</div>
					<ul class="zhengce-hot-list" id="zhengce-hot-list">

					</ul>
				</div>

			<!-- 政策分析结束 -->



			</div>
			<%--活动跟踪部分--%>
			<div class="schd-container">
				<div class="index-public-title">
					<a href="">活动跟踪</a>
				</div>
				<div class="title">
					<div class="tab-btn-wrapper" id="schd-tab">
						<div class="tab-btn active" id="schd-scz">双创周
						</div><div class="tab-btn" id="schd-cxzg">创响中国</div>
					</div>
				</div>

				<div class="schd-tab-content-list">
					<div>
						<ul id="schd-list"></ul>
					</div>
				</div>
			</div>
			<%--服务拓展--%>
			<div class="scfw-container">
				<div class="index-public-title">
					<a href="skipServiceDevelopment.html">服务拓展</a>
				</div>
				<div class="title">
					<div class="tab-btn-wrapper" id="fuwu-tab">
						<div class="tab-btn active">创业者
						</div><div class="tab-btn">孵化器及众创空间</div>
					</div>
				</div>
				<div class="fuwu-content" id="fuwu-content">
					<div class="active">
						<ul class="fuwu-list">
							<li>
								<a href="http://sccs.youedata.com/yhzccx.html">
									<div class="img-wrapper"><img src="/imgs/shuishou.png"></div>
								</a>
							</li>
							<li>
								<a href="http://sccs.youedata.com/zhengceku.html">
									<div class="img-wrapper"><img src="/imgs/xwqy.png"></div>
								</a>
							</li>
							<li>
								<a href="http://sccs.youedata.com/serviceExp.html">
									<div class="img-wrapper"><img src="/imgs/jijin.png"></div>
								</a>
							</li>
						</ul>
					</div>
					<div>
						<ul class="fuwu-list">
							<li>
								<a href="http://sccs.youedata.com/serviceAppr.html">
									<div class="img-wrapper"><img src="/imgs/fuhuaqi.png"></div>
								</a>
							</li>
						</ul>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>


</body>
</html>