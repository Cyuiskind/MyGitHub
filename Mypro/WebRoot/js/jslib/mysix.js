ShowSix();
function ShowSix() {
	$.ajax({
		type : "POST",
		async : true, // 同步执行 结束请求后再在执行下一个ajax
		url : "myone/extend.do",
		dataType : "JSON",
		success : function(data) {
			ifextend(data);
		}

	});
}

function ifextend(data){
	var myChart = echarts.init(document.getElementById('six1'));
	var option = {
		    title: {
		        text: '袭击是否持续超过一天',
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
		        data: ['超过一天', '未超过一天']
		    },
		    series: [
		        {
		            name: '袭击是否超过一天',
		            type: 'pie',
		            radius: '55%',
		            center: ['50%', '60%'],
		            data: [
		                {value: data.extend, name: '超过一天'},
		                {value: data.no, name: '未超过一天'}
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


ShowSix1();
function ShowSix1() {
	$.ajax({
		type : "POST",
		async : true, // 同步执行 结束请求后再在执行下一个ajax
		url : "myone/certain.do",
		dataType : "JSON",
		success : function(data) {
			ifcertain(data);
		}

	});
}

function ifcertain(data){
	var myChart = echarts.init(document.getElementById('six2'));
	var option = {
		    title: {
		        text: '组织是否确定',
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
		        data: ['组织确定', '组织不确定']
		    },
		    series: [
		        {
		            name: '组织是否确定',
		            type: 'pie',
		            radius: '55%',
		            center: ['50%', '60%'],
		            data: [
		            	{value: data.certain, name: '组织确定'},
		                {value: data.no, name: '组织不确定'}
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