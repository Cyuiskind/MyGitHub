ShowTwo();
function ShowTwo() {
	$.ajax({
		type : "POST",
		async : true, // 同步执行 结束请求后再在执行下一个ajax
		url : "myone/yearhurt.do",
		dataType : "JSON",
		success : function(data) {
			yearhurt(data);
		}

	});
}

function yearhurt(data){
	var myChart = echarts.init(document.getElementById('two1'));
	var option = {
            title: {
                text: '恐怖袭击造成的伤亡数'
            },
		    tooltip: {
		        trigger: 'axis',
		        axisPointer: {            // 坐标轴指示器，坐标轴触发有效
		            type: 'shadow'        // 默认为直线，可选为：'line' | 'shadow'
		        }
		    },
		    legend: {
		        data: ['人']
		    },
		    grid: {
		        left: '3%',
		        right: '4%',
		        bottom: '3%',
		        containLabel: true
		    },
		    xAxis: [
		        {
		            data: data.year
		        }
		    ],
		    yAxis: [
		        {
		            type: 'value'
		        }
		    ],
		    series: [
		        {
		            name: '死亡人数',
		            type: 'bar',
		            stack:'hurt',
		            data: data.dnum
		        },
		        {
		            name: '受伤人数',
		            type: 'bar',
		            stack:'hurt',
		            data: data.wnum
		        }
		    ]
		};
	myChart.setOption(option);
}

ShowTwo1();
function ShowTwo1() {
	$.ajax({
		type : "POST",
		async : true, // 同步执行 结束请求后再在执行下一个ajax
		url : "myone/countryhurt.do",
		dataType : "JSON",
		success : function(data) {
			countryhurt(data);
		}

	});
}

function countryhurt(data){
	var myChart = echarts.init(document.getElementById('two2'));
	var option = {
            title: {
                text: '恐怖袭击造成伤亡最多的国家'
            },
		    tooltip: {
		        trigger: 'axis',
		        axisPointer: {            // 坐标轴指示器，坐标轴触发有效
		            type: 'shadow'        // 默认为直线，可选为：'line' | 'shadow'
		        }
		    },
		    legend: {
		        data: ['人']
		    },
		    grid: {
		        left: '3%',
		        right: '4%',
		        bottom: '3%',
		        containLabel: true
		    },
		    xAxis: [
		        {
		            data: data.country
		        }
		    ],
		    yAxis: [
		        {
		            type: 'value'
		        }
		    ],
		    series: [
		        {
		            name: '死亡人数',
		            type: 'bar',
		            stack:'hurt',
		            data: data.dnum
		        },
		        {
		            name: '受伤人数',
		            type: 'bar',
		            stack:'hurt',
		            data: data.wnum
		        }
		    ]
		};
	myChart.setOption(option);
}