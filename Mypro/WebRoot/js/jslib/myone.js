ShowOne();
function ShowOne() {
	$.ajax({
		type : "POST",
		async : true, // 同步执行 结束请求后再在执行下一个ajax
		url : "myone/peryear.do",
		dataType : "JSON",
		success : function(data) {
			yeardata(data);
		}

	});
}

function yeardata(data){
	var myChart = echarts.init(document.getElementById('one1'));
	var option = {
            title: {
                text: '每年发生的恐怖袭击事件'
            },
            tooltip: {},
            legend: {
                data:['次']
            },
            xAxis: {
                data: data.year
            },
            yAxis: {},
            series: [{
                name: '次',
                type: 'line',
                data: data.num
            }]
        };
	myChart.setOption(option);
}

ShowOne1();
function ShowOne1() {
	$.ajax({
		type : "POST",
		async : true, // 同步执行 结束请求后再在执行下一个ajax
		url : "myone/countryall.do",
		dataType : "JSON",
		success : function(data) {
			yeardata1(data);
		}

	});
}

function yeardata1(data){
	var myChart = echarts.init(document.getElementById('one2'));
	var option = {
            title: {
                text: '发生恐怖袭击最多的国家'
            },
            tooltip: {},
            legend: {
                data:['件']
            },
            xAxis: {
                data: data.country
            },
            yAxis: {},
            series: [{
                name: '件',
                type: 'bar',
                data: data.num
            }]
        };
	myChart.setOption(option);
}