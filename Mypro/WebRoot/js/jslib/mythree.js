ShowThree();
function ShowThree() {
	$.ajax({
		type : "POST",
		async : true, // 同步执行 结束请求后再在执行下一个ajax
		url : "myone/weap.do",
		dataType : "JSON",
		success : function(data) {
			weap(data);
		}

	});
}

function weap(data){
	var myChart = echarts.init(document.getElementById('three1'));
	var option = {
		    backgroundColor: '#707070',

		    title: {
		        text: '恐怖袭击所使用武器占比',
		        left: 'center',
		        top: 20,
		        textStyle: {
		            color: '#ccc'
		        }
		    },

		    tooltip: {
		        trigger: 'item',
		        formatter: '{a} <br/>{b} : {c} ({d}%)'
		    },

		    visualMap: {
		        show: false,
		        min: 80,
		        max: 600,
		        inRange: {
		            colorLightness: [0, 1]
		        }
		    },
		    series: [
		        {
		            name: '访问来源',
		            type: 'pie',
		            radius: '55%',
		            center: ['50%', '50%'],
		            data: [
		                {value: data.value0, name: data.name0},
		                {value: data.value1, name: data.name1},
		                {value: data.value2, name: data.name2},
		                {value: data.value3, name: data.name3},
		                {value: data.value4, name: data.name4}
		            ].sort(function (a, b) { return a.value - b.value; }),
		            roseType: 'radius',
		            label: {
		                color: 'rgba(255, 255, 255, 0.3)'
		            },
		            labelLine: {
		                lineStyle: {
		                    color: 'rgba(255, 255, 255, 0.3)'
		                },
		                smooth: 0.2,
		                length: 10,
		                length2: 20
		            },
		            itemStyle: {
		                color: '#c23531',
		                shadowBlur: 200,
		                shadowColor: 'rgba(0, 0, 0, 0.5)'
		            },

		            animationType: 'scale',
		            animationEasing: 'elasticOut',
		            animationDelay: function (idx) {
		                return Math.random() * 200;
		            }
		        }
		    ]
		};
	myChart.setOption(option);
}