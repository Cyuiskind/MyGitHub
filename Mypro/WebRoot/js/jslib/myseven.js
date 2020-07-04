ShowSeven();
function ShowSeven() {
	$.ajax({
		type : "POST",
		async : true, // 同步执行 结束请求后再在执行下一个ajax
		url : "myone/citytime.do",
		dataType : "JSON",
		success : function(data) {
			citytime(data);
		}

	});
}

function citytime(data){
	var myChart = echarts.init(document.getElementById('seven1'));
	var option = {
		            title: {
		                text: '发生恐怖袭击最多的城市'
		            },
		            tooltip: {},
		            legend: {
		                data:['件']
		            },
		            xAxis: {
		                data: data.city
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

ShowSeven1();
function ShowSeven1() {
	$.ajax({
		type : "POST",
		async : true, // 同步执行 结束请求后再在执行下一个ajax
		url : "myone/cityhurt.do",
		dataType : "JSON",
		success : function(data) {
			cityhurt(data);
		}

	});
}

function cityhurt(data){
	var myChart = echarts.init(document.getElementById('seven2'));
	var option = {
            title: {
                text: '因恐怖袭击造成的伤亡数最多的城市'
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
		            data: data.city
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