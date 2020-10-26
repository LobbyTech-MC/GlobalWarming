# GlobalWarming 全球变暖

这个粘液科技插件将全球变暖机制加入到游戏之中.  
一个有用的插件, 99% 可配置.

## 导航
* [下载](#下载)
* [配置](#配置)
* [机制](#机制)
  * [环境机制](#环境机制)
  * [污染机器](#污染机器)
  * [新闻系统](#新闻系统)
* [物品和机器](#物品和机器)
* [API](#API)

## 下载
你可以在[这里](https://github.com/poma123/GlobalWarming/tree/master/src/main/resources/config.yml)下载插件.
## 配置

当你成功安装本插件的时候, 看一下 [config.yml](https://github.com/ClayCoffee/GlobalWarming/tree/master/src/main/resources/config.yml).
- `worlds` 允许你设置插件启用的白名单或黑名单.
- `world-filter-type` 定义插件启用世界的判断 (允许的类型: ``blacklist``, ``whitelist``)
- 在 `mechanics` 项下, 你可以自定义可用的气候变化机制
- `pollution` 项定义污染和改善环境的机器, 物品和生物
- 在 `temperature-options` 项下, 你可以配置根据污染和天气计算温度的方法.

别忘了在更改完配置后重启你的服务器!
## 机制
### 环境机制:

- 森林火灾 (发生在已加载的区块, 在高温条件下, 火将会出现在该区块的一个随机的最高的方块上)
- 冰川融化 (发生在已加载的区块, 在高温条件下, 冰将会随机融化成水)
- 玩家移动变缓 (当温度过高或过低时)
- 玩家燃烧 (当温度极高时)

### 污染机制:
污染程度在每个世界中独立存在. 有两种污染机制:

##### 1. 产生污染
- 当动物繁殖时
- 当一个污染的粘液科技机器完成一个任务时
- 当一个污染的粘液科技物品用于机器时

##### 2. 净化污染
- 当树苗成长时
- 当一个改善环境的粘液科技完成一个任务时. (默认: 空气压缩器)

### 新闻系统:
- 当世界污染继续增加的时候, 一个新的 "劲爆新闻" 消息将会广播给在该世界的所有玩家, 所有信息均选自于现实世界.

## 物品和机器
- 温度计 (显示当前温度)
- 空气质量检测仪 (显示当前温度上升值)
- 空气压缩器 (将二氧化碳压缩进空罐子, 顺带改善污染)
- 空罐
- 二氧化碳罐 (含有压缩二氧化碳)
- 朱砂 (GEO资源, 合成汞需要)
- 汞 (资源, 合成空气压缩器需要)
- 过滤器 (合成空气压缩器需要)

![image](https://user-images.githubusercontent.com/25465545/96293130-90bcfa80-0fea-11eb-9f16-d57105148973.png)
## API
你可以在 [`me.poma123.globalwarming.api`](https://github.com/poma123/GlobalWarming/tree/master/src/main/java/me/poma123/globalwarming/api) 找到API文档.
