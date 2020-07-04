ShowFive();
function ShowFive() {
	$.ajax({
		type : "POST",
		async : true, // 同步执行 结束请求后再在执行下一个ajax
		url : "myone/succ.do",
		dataType : "JSON",
		success : function(data) {
			ifsucc(data);
		}

	});
}

function ifsucc(data){
	var myChart = echarts.init(document.getElementById('five1'));
	var option = {
		    title: {
		        text: '袭击成功与否对比',
		       // subtext: '纯属虚构',
		        left: 'center'
		    },
		    tooltip: {
		        trigger: 'item',
		        formatter: '{a} <br/>{b} : {c} ({d}%)'
		    },
		    legend: {
		        orient: 'vertical',
		        left: 'left',
		        data: ['成功', '失败']
		    },
		    series: [
		        {
		            name: '是否成功',
		            type: 'pie',
		            radius: '55%',
		            center: ['50%', '60%'],
		            data: [
		                {value: data.succ, name: '成功'},
		                {value: data.fail, name: '失败'}
		            ],
		            emphasis: {
		                itemStyle: {
		                    shadowBlur: 10,
		                    shadowOffsetX: 0,
		                    shadowColor: 'rgba(0, 0, 0, 0.5)'
		                }
		            }
		        }
		    ]
		};
	myChart.setOption(option);
}


ShowFive1();
function ShowFive1() {
	$.ajax({
		type : "POST",
		async : true, // 同步执行 结束请求后再在执行下一个ajax
		url : "myone/suice.do",
		dataType : "JSON",
		success : function(data) {
			ifsuice(data);
		}

	});
}

function ifsuice(data){
	var myChart = echarts.init(document.getElementById('five2'));
	var option = {
		    title: {
		        text: '袭击是否为自杀式',
		       // subtext: '纯属虚构',
		        left: 'center'
		    },
		    tooltip: {
		        trigger: 'item',
		        formatter: '{a} <br/>{b} : {c} ({d}%)'
		    },
		    legend: {
		        orient: 'vertical',
		        left: 'left',
		        data: ['自杀式', '非自杀式']
		    },
		    series: [
		        {
		            name: '是否为自杀式',
		            type: 'pie',
		            radius: '55%',
		            center: ['50%', '60%'],
		            data: [
		            	{value: data.no, name: '非自杀式'},
		                {value: data.suic, name: '自杀式'}
		            ],
		            emphasis: {
		                itemStyle: {
		                    shadowBlur: 10,
		                    shadowOffsetX: 0,
		                    shadowColor: 'rgba(0, 0, 0, 0.5)'
		                }
		            }
		        }
		    ]
		};
	myChart.setOption(option);
}