ShowFour();
function ShowFour() {
	$.ajax({
		type : "POST",
		async : true, // 同步执行 结束请求后再在执行下一个ajax
		url : "myone/viccountry.do",
		dataType : "JSON",
		success : function(data) {
			viccountry(data);
		}

	});
}

function viccountry(data){
	var myChart = echarts.init(document.getElementById('four1'));
	var option = {
			color:'#880000',
            title: {
                text: '受害者国籍前十'
            },
            tooltip: {},
            legend: {
                data:['次']
            },
            xAxis: {
                data: data.country
            },
            yAxis: {},
            series: [{
                name: '次',
                type: 'bar',
                data: data.num
            }]
        };
	myChart.setOption(option);
}

ShowFour1();
function ShowFour1() {
	$.ajax({
		type : "POST",
		async : true, // 同步执行 结束请求后再在执行下一个ajax
		url : "myone/victype.do",
		dataType : "JSON",
		success : function(data) {
			victype(data);
		}

	});
}

function victype(data){
	var myChart = echarts.init(document.getElementById('four2'));
	var option = {
			color:'#880000',
            title: {
                text: '受害者分类前十'
            },
            tooltip: {},
            legend: {
                data:['次']
            },
            xAxis: {
                data: data.type
            },
            yAxis: {},
            series: [{
                name: '次',
                type: 'bar',
                data: data.num
            }]
        };
	myChart.setOption(option);
}