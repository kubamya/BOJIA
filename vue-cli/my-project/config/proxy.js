/**
 * 项目代理配置
 * 用法：https://github.com/chimurai/http-proxy-middleware#proxycontext-config
 */
// const debuggerStatus = false
// const severTarget = 'http://172.18.15.249:9012';
// const severTarget = 'http://172.18.40.189:9099'; // 李天赋的地址
// const severTarget = 'http://172.18.40.41:9099'; // 杨阳-5的地址
// const severTarget = 'http://172.18.41.31:9099/'; // 鸿喆的地址
// const severTarget = 'http://172.18.40.231:9099/'; // 谢阳的地址
// const mockTarget = 'http://oapi.thunisoft.com/mock/385';
const useTarget = 'http://t.weather.sojson.com';
module.exports = {
  '/weatherApi': {
    target: useTarget,
    changeOrigin: true,
    pathRewrite: {
      '^/weatherApi': '/api/weather/city/101071201',
    },
  },
  baseUrl: {
    target: useTarget,
  }
}
