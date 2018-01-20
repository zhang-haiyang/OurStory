package zhy.com.story.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.CollapsibleActionView;
import android.support.v7.widget.Toolbar;
import android.webkit.WebView;
import android.widget.TextView;


import zhy.com.story.R;

/**
 * 故事详情页
 */
public class StoryDetailActivity extends AppCompatActivity {



    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story_detail);
        initView();
    }

    private void initView(){

        webView = findViewById(R.id.web);

//        String catCircleStyle = "<style>body, span, p{font-size: 17px !important;line-height: 28px !important;text-align: left;color: #484848;font-family: 'PingFangSC-Regular', 'Microsoft YaHei', '微软雅黑', 'Hiragino Sans GB',  '宋体', Arial, Verdana, sans-serif;} img {padding: 12px 0; width: 100%; height: auto;}</style>";
//        String con = "<div class=\"art-img-box\"><img src=\"http://file.yirimao.com/1516346872774.png\"></div><div class=\"art-img-box\"><img src=\"http://file.yirimao.com/1516346872485.png\"></div><div class=\"art-img-box\"><img src=\"http://file.yirimao.com/1516346872343.png\"></div><div class=\"art-img-box\"><img src=\"http://file.yirimao.com/1516346872561.png\"></div><div class=\"art-img-box\"><img src=\"http://file.yirimao.com/1516346872702.png\"></div><div class=\"art-img-box\"><img src=\"http://file.yirimao.com/1516346872719.png\"></div><div class=\"art-img-box\"><img src=\"http://file.yirimao.com/1516346872694.png\"></div><div class=\"art-img-box\"><img src=\"http://file.yirimao.com/1516346872712.png\"></div><br>萌萌哒张海洋\n";

        String SSS = "<div data-note-content class=\"show-content\">\n" +
                "          <p>文图/勒克儿</p><p>说起五大连池，那是与四川阿坝州九寨沟黄龙甘孜州新都桥稻城一样，是摄影爱好者的天堂。这些地方春夏秋美景铺天盖地，寒冬腊月时节，关于四川的美景还偶见，但五大连池像什么样，网上更鲜见。要想与众不同，6点出发，登山去拍五大连池日出，拍黎明时分刚刚苏醒的一座城市，尤其是零下30度的环境，总该绝无仅有了吧？</p><p>这么想，我们一群小伙伴也这么做了。</p><p>早晨8点，迎着太阳，玩一把开水泼出去瞬间结霜成雾的游戏。这样的景观，按照国外摄友的介绍，只有零下40度才有可能，但本文叙述称的零下30度，是墨迹天气当时的显示，准不准，很难说，但是客观依据。</p><div class=\"image-package\">\n" +
                "<div class=\"image-container\" style=\"max-width: 640px; max-height: 404px;\">\n" +
                "<div class=\"image-container-fill\" style=\"padding-bottom: 63.129999999999995%;\"></div>\n" +
                "<div class=\"image-view\" data-width=\"640\" data-height=\"404\"><img data-original-src=\"//upload-images.jianshu.io/upload_images/7824180-690576e9220b425b\" data-original-width=\"640\" data-original-height=\"404\" data-original-format=\"image/jpeg\" data-original-filesize=\"41809\"></div>\n" +
                "</div>\n" +
                "<div class=\"image-caption\">\n" +
                "\n" +
                "五大连池。药泉山上。日出。\u200B  </div>\n" +
                "</div><div class=\"image-package\">\n" +
                "<div class=\"image-container\" style=\"max-width: 640px; max-height: 427px;\">\n" +
                "<div class=\"image-container-fill\" style=\"padding-bottom: 66.72%;\"></div>\n" +
                "<div class=\"image-view\" data-width=\"640\" data-height=\"427\"><img data-original-src=\"//upload-images.jianshu.io/upload_images/7824180-7696a3077ca9a0ff\" data-original-width=\"640\" data-original-height=\"427\" data-original-format=\"image/jpeg\" data-original-filesize=\"38132\"></div>\n" +
                "</div>\n" +
                "<div class=\"image-caption\">\n" +
                "\n" +
                "零下30度。五大连池。药泉山下。黎明时分。\u200B\n" +
                "\n" +
                "</div>\n" +
                "</div><p>1月23日6点，我们背起长枪短炮扛着脚架，睡眼惺忪嚼着面包从五大连池市区温都水城宾馆出发到药泉山，20公里路程，很近。</p><p>之所以选择去药泉山拍摄，是听当地人介绍说，那里地势虽不高，但视野开阔，可拍日出，并可鸟瞰整个五大连池镇以及其他景区。</p><div class=\"image-package\">\n" +
                "<div class=\"image-container\" style=\"max-width: 640px; max-height: 426px;\">\n" +
                "<div class=\"image-container-fill\" style=\"padding-bottom: 66.56%;\"></div>\n" +
                "<div class=\"image-view\" data-width=\"640\" data-height=\"426\"><img data-original-src=\"//upload-images.jianshu.io/upload_images/7824180-e8127bd9b8e619bd\" data-original-width=\"640\" data-original-height=\"426\" data-original-format=\"image/jpeg\" data-original-filesize=\"75301\"></div>\n" +
                "</div>\n" +
                "<div class=\"image-caption\">\n" +
                "\n" +
                "五大连池。药泉山一角。\u200B这山就像一个小小土山包。最顶上的，就是观音像。  </div>\n" +
                "</div><div class=\"image-package\">\n" +
                "<div class=\"image-container\" style=\"max-width: 640px; max-height: 426px;\">\n" +
                "<div class=\"image-container-fill\" style=\"padding-bottom: 66.56%;\"></div>\n" +
                "<div class=\"image-view\" data-width=\"640\" data-height=\"426\"><img data-original-src=\"//upload-images.jianshu.io/upload_images/7824180-0e4752a351977502\" data-original-width=\"640\" data-original-height=\"426\" data-original-format=\"image/jpeg\" data-original-filesize=\"51910\"></div>\n" +
                "</div>\n" +
                "<div class=\"image-caption\">\n" +
                "\n" +
                "药泉山鸟瞰：远处的五大连池市。\u200B\n" +
                "\n" +
                "</div>\n" +
                "</div><p>据资料介绍，药泉山也叫极乐山，是五大连池14座火山中最小的，也是海拔最低的一座，远看像个土山。这山位于五大连池火山群南部，海拔355米，高出地面60米，火口底部平坦，山下分布许多矿泉。山下二龙眼泉流水潺潺，平目远眺，五大连池景区的街景以及一望无垠的农田等尽收眼底。在火山口内，座落着闻名遐迩的钟灵禅寺，这也是世界上唯一的建在火山口里的寺庙。</p><div class=\"image-package\">\n" +
                "<div class=\"image-container\" style=\"max-width: 640px; max-height: 426px;\">\n" +
                "<div class=\"image-container-fill\" style=\"padding-bottom: 66.56%;\"></div>\n" +
                "<div class=\"image-view\" data-width=\"640\" data-height=\"426\"><img data-original-src=\"//upload-images.jianshu.io/upload_images/7824180-683b732eedb5e790\" data-original-width=\"640\" data-original-height=\"426\" data-original-format=\"image/jpeg\" data-original-filesize=\"46927\"></div>\n" +
                "</div>\n" +
                "<div class=\"image-caption\">\n" +
                "\n" +
                "药泉山大门。这个季节，没有游人，大门敞开\u200B随便你玩。\n" +
                "\n" +
                "</div>\n" +
                "</div><p>公元1719-1721年，火山爆发堵塞了当年的河道，在现在的五大连池景区范围内形成了五个互相连通的熔岩堰塞湖。五大连地除五个堰塞湖外，还有许多古代和近代的火山。中、近期形成的火山共14座。因此这里成为有景色奇特的火山风光、丰富完整的火山地貌和矿泉“圣水”的国内著名综合性天然风景名胜区。</p><div class=\"image-package\">\n" +
                "<div class=\"image-container\" style=\"max-width: 640px; max-height: 427px;\">\n" +
                "<div class=\"image-container-fill\" style=\"padding-bottom: 66.72%;\"></div>\n" +
                "<div class=\"image-view\" data-width=\"640\" data-height=\"427\"><img data-original-src=\"//upload-images.jianshu.io/upload_images/7824180-9118ad7f3d51679c\" data-original-width=\"640\" data-original-height=\"427\" data-original-format=\"image/jpeg\" data-original-filesize=\"53262\"></div>\n" +
                "</div>\n" +
                "<div class=\"image-caption\">\n" +
                "\n" +
                "零下30度。五大连池。药泉山下。刚苏醒的城镇。\u200B  </div>\n" +
                "</div><div class=\"image-package\">\n" +
                "<div class=\"image-container\" style=\"max-width: 640px; max-height: 430px;\">\n" +
                "<div class=\"image-container-fill\" style=\"padding-bottom: 67.19000000000001%;\"></div>\n" +
                "<div class=\"image-view\" data-width=\"640\" data-height=\"430\"><img data-original-src=\"//upload-images.jianshu.io/upload_images/7824180-1070830d2d2a99bf\" data-original-width=\"640\" data-original-height=\"430\" data-original-format=\"image/jpeg\" data-original-filesize=\"36494\"></div>\n" +
                "</div>\n" +
                "<div class=\"image-caption\">\n" +
                "\n" +
                "远处隆起的地方，就是五大连池火山群中其中一个火山口。\u200B\n" +
                "\n" +
                "</div>\n" +
                "</div><p>在仅仅高出地面60米的这座“山”上拍日出，小伙伴们也是醉了——凌晨6点30爬上山顶，见观音像前有个不大的平台，但这平台明显只能远观山下的城镇和远处的两座火山口，看微红的天边，日出应该在平台的左手边，但有树木挡着，根本无法拍摄。拍不到日出，就拍一座城市刚刚苏醒的样纸，那千万家屋顶黎明齐齐冒出的炊烟，不仅壮观无比，而且可能还歪打正着，基本上是人无我有，呵呵。</p><div class=\"image-package\">\n" +
                "<div class=\"image-container\" style=\"max-width: 640px; max-height: 426px;\">\n" +
                "<div class=\"image-container-fill\" style=\"padding-bottom: 66.56%;\"></div>\n" +
                "<div class=\"image-view\" data-width=\"640\" data-height=\"426\"><img data-original-src=\"//upload-images.jianshu.io/upload_images/7824180-f03102d82b8fcc1e\" data-original-width=\"640\" data-original-height=\"426\" data-original-format=\"image/jpeg\" data-original-filesize=\"41782\"></div>\n" +
                "</div>\n" +
                "<div class=\"image-caption\">\n" +
                "\n" +
                "零下30度。五大连池。药泉山下。黎明时分。\u200B  </div>\n" +
                "</div><div class=\"image-package\">\n" +
                "<div class=\"image-container\" style=\"max-width: 640px; max-height: 427px;\">\n" +
                "<div class=\"image-container-fill\" style=\"padding-bottom: 66.72%;\"></div>\n" +
                "<div class=\"image-view\" data-width=\"640\" data-height=\"427\"><img data-original-src=\"//upload-images.jianshu.io/upload_images/7824180-f5d267e2ea31d380\" data-original-width=\"640\" data-original-height=\"427\" data-original-format=\"image/jpeg\" data-original-filesize=\"53262\"></div>\n" +
                "</div>\n" +
                "<div class=\"image-caption\">\n" +
                "\n" +
                "零下30度。五大连池。药泉山下。黎明时分。\u200B  </div>\n" +
                "</div><div class=\"image-package\">\n" +
                "<div class=\"image-container\" style=\"max-width: 640px; max-height: 426px;\">\n" +
                "<div class=\"image-container-fill\" style=\"padding-bottom: 66.56%;\"></div>\n" +
                "<div class=\"image-view\" data-width=\"640\" data-height=\"426\"><img data-original-src=\"//upload-images.jianshu.io/upload_images/7824180-9c8e725fd9c86e61\" data-original-width=\"640\" data-original-height=\"426\" data-original-format=\"image/jpeg\" data-original-filesize=\"60354\"></div>\n" +
                "</div>\n" +
                "<div class=\"image-caption\">\n" +
                "\n" +
                "零下30度。五大连池。药泉山下。黎明时分。\u200B  </div>\n" +
                "</div><div class=\"image-package\">\n" +
                "<div class=\"image-container\" style=\"max-width: 640px; max-height: 431px;\">\n" +
                "<div class=\"image-container-fill\" style=\"padding-bottom: 67.34%;\"></div>\n" +
                "<div class=\"image-view\" data-width=\"640\" data-height=\"431\"><img data-original-src=\"//upload-images.jianshu.io/upload_images/7824180-d02100a6dd7057be\" data-original-width=\"640\" data-original-height=\"431\" data-original-format=\"image/jpeg\" data-original-filesize=\"31902\"></div>\n" +
                "</div>\n" +
                "<div class=\"image-caption\">\n" +
                "\n" +
                "零下30度。五大连池。药泉山下。日出时分。\u200B\n" +
                "\n" +
                "</div>\n" +
                "</div><p>在零下30度的山上等待天亮，这种赶脚只有脑壳有包的人才有资格享受。因为太冷，原地呆着那更是神经不正常。这山顶很小，大伙儿东串西串到处找地儿，最终一个小伙伴发现一个上山的步行道梯坎处略开阔，勉强阔以拍日出。大伙儿闻听后扛起脚架到了那里一看，这里是一个上下山的步道拐弯处，而且地方很窄，“最好”的位置只能架两三个脚架。</p><div class=\"image-package\">\n" +
                "<div class=\"image-container\" style=\"max-width: 640px; max-height: 426px;\">\n" +
                "<div class=\"image-container-fill\" style=\"padding-bottom: 66.56%;\"></div>\n" +
                "<div class=\"image-view\" data-width=\"640\" data-height=\"426\"><img data-original-src=\"//upload-images.jianshu.io/upload_images/7824180-8ae1edbf73fd16b5\" data-original-width=\"640\" data-original-height=\"426\" data-original-format=\"image/jpeg\" data-original-filesize=\"65275\"></div>\n" +
                "</div>\n" +
                "<div class=\"image-caption\">\n" +
                "\n" +
                "就这个地儿，勉强可以架三个脚架。  </div>\n" +
                "</div><div class=\"image-package\">\n" +
                "<div class=\"image-container\" style=\"max-width: 640px; max-height: 442px;\">\n" +
                "<div class=\"image-container-fill\" style=\"padding-bottom: 69.06%;\"></div>\n" +
                "<div class=\"image-view\" data-width=\"640\" data-height=\"442\"><img data-original-src=\"//upload-images.jianshu.io/upload_images/7824180-9a29563251ca5995\" data-original-width=\"640\" data-original-height=\"442\" data-original-format=\"image/jpeg\" data-original-filesize=\"81517\"></div>\n" +
                "</div>\n" +
                "<div class=\"image-caption\">\n" +
                "\n" +
                "排在后一拨的小伙伴很捉急，索性在坡上架起脚架等待那灿烂的一瞬。\u200B  </div>\n" +
                "</div><div class=\"image-package\">\n" +
                "<div class=\"image-container\" style=\"max-width: 640px; max-height: 419px;\">\n" +
                "<div class=\"image-container-fill\" style=\"padding-bottom: 65.47%;\"></div>\n" +
                "<div class=\"image-view\" data-width=\"640\" data-height=\"419\"><img data-original-src=\"//upload-images.jianshu.io/upload_images/7824180-35b03123efaf8f09\" data-original-width=\"640\" data-original-height=\"419\" data-original-format=\"image/jpeg\" data-original-filesize=\"77025\"></div>\n" +
                "</div>\n" +
                "<div class=\"image-caption\">\n" +
                "\n" +
                "这就是拍日出的地势——步道拐弯处，但左手边坡道上很多树木遮挡，视野相当捉急。\n" +
                "\n" +
                "</div>\n" +
                "</div><p>好吧，排队，一拨一拨的来，无论拍的好坏每人都只有两三分钟。都知道太阳喷薄而出就那么一两分钟，第一拨和最后一拨肯定只能拍个大概，大伙儿都谦让着最佳拍摄时机，争执不下，最终还是领队宰指：最佳时机留给设备最好的……</p><p>排好队了。第一拨上。零下30度的原地等待是备受煎熬的。此时是7:26分，距离日出还有几分钟。</p><div class=\"image-package\">\n" +
                "<div class=\"image-container\" style=\"max-width: 640px; max-height: 439px;\">\n" +
                "<div class=\"image-container-fill\" style=\"padding-bottom: 68.58999999999999%;\"></div>\n" +
                "<div class=\"image-view\" data-width=\"640\" data-height=\"439\"><img data-original-src=\"//upload-images.jianshu.io/upload_images/7824180-9f03bc3e08d92cb3\" data-original-width=\"640\" data-original-height=\"439\" data-original-format=\"image/jpeg\" data-original-filesize=\"30765\"></div>\n" +
                "</div>\n" +
                "<div class=\"image-caption\">\n" +
                "\n" +
                "零下30度的这份等待和执着，我们是否应该向把美景无私奉献给网友的拍摄者致个敬呢？呵呵。\u200B  </div>\n" +
                "</div><div class=\"image-package\">\n" +
                "<div class=\"image-container\" style=\"max-width: 640px; max-height: 447px;\">\n" +
                "<div class=\"image-container-fill\" style=\"padding-bottom: 69.84%;\"></div>\n" +
                "<div class=\"image-view\" data-width=\"640\" data-height=\"447\"><img data-original-src=\"//upload-images.jianshu.io/upload_images/7824180-e43fa7e2ccb2e8b1\" data-original-width=\"640\" data-original-height=\"447\" data-original-format=\"image/jpeg\" data-original-filesize=\"20301\"></div>\n" +
                "</div>\n" +
                "<div class=\"image-caption\">\n" +
                "\n" +
                "轮到我拍了，按照预先设定的参数，也没更多时间修正，好坏就这样了，反正来过，拍过。\u200B  </div>\n" +
                "</div><div class=\"image-package\">\n" +
                "<div class=\"image-container\" style=\"max-width: 640px; max-height: 429px;\">\n" +
                "<div class=\"image-container-fill\" style=\"padding-bottom: 67.03%;\"></div>\n" +
                "<div class=\"image-view\" data-width=\"640\" data-height=\"429\"><img data-original-src=\"//upload-images.jianshu.io/upload_images/7824180-171671f4d03b2ebc\" data-original-width=\"640\" data-original-height=\"429\" data-original-format=\"image/jpeg\" data-original-filesize=\"32261\"></div>\n" +
                "</div>\n" +
                "<div class=\"image-caption\">\n" +
                "\n" +
                "零下30度。五大连池。药泉山下。日出时分。\u200B  </div>\n" +
                "</div><div class=\"image-package\">\n" +
                "<div class=\"image-container\" style=\"max-width: 640px; max-height: 425px;\">\n" +
                "<div class=\"image-container-fill\" style=\"padding-bottom: 66.41%;\"></div>\n" +
                "<div class=\"image-view\" data-width=\"640\" data-height=\"425\"><img data-original-src=\"//upload-images.jianshu.io/upload_images/7824180-56c42771de5b86c9\" data-original-width=\"640\" data-original-height=\"425\" data-original-format=\"image/jpeg\" data-original-filesize=\"34042\"></div>\n" +
                "</div>\n" +
                "<div class=\"image-caption\">\n" +
                "\n" +
                "零下30度。五大连池。药泉山下。日出时分。\u200B  </div>\n" +
                "</div><div class=\"image-package\">\n" +
                "<div class=\"image-container\" style=\"max-width: 640px; max-height: 439px;\">\n" +
                "<div class=\"image-container-fill\" style=\"padding-bottom: 68.58999999999999%;\"></div>\n" +
                "<div class=\"image-view\" data-width=\"640\" data-height=\"439\"><img data-original-src=\"//upload-images.jianshu.io/upload_images/7824180-2a2a3ca6c2cab03a\" data-original-width=\"640\" data-original-height=\"439\" data-original-format=\"image/jpeg\" data-original-filesize=\"41391\"></div>\n" +
                "</div>\n" +
                "<div class=\"image-caption\"></div>\n" +
                "</div><p>零下30度。五大连池。药泉山下。日出时分。\u200B</p><p>\u200B</p>\n" +
                "        </div>\n" +
                "    </div>\n" +
                "\n" +
                "      <div class=\"support-author\"></div>\n" +
                "\n" +
                "      <div class=\"show-foot\">\n" +
                "        <a class=\"notebook\" href=\"/nb/16319346\">\n" +
                "          <i class=\"iconfont ic-search-notebook\"></i>\n" +
                "          <span>日记本</span>\n" +
                "</a>        <div class=\"copyright\" data-toggle=\"tooltip\" data-html=\"true\" data-original-title=\"转载请联系作者获得授权，并标注“简书作者”。\">\n" +
                "          © 著作权归作者所有\n" +
                "        </div>\n" +
                "        <div class=\"modal-wrap\" data-report-note>\n" +
                "          <a id=\"report-modal\">举报文章</a>\n" +
                "        </div>\n" +
                "      </div>\n" +
                "\n" +
                "    <!-- 文章底部作者信息 -->\n" +
                "      <div class=\"follow-detail\">\n" +
                "        <div class=\"info\">\n" +
                "          <a class=\"avatar\" href=\"/u/134bbdcf71d2\">\n" +
                "            <img src=\"//upload.jianshu.io/users/upload_avatars/7824180/b257a47e-8b3e-4cb2-ad05-6c8419f30dce.jpg?imageMogr2/auto-orient/strip|imageView2/1/w/96/h/96\" alt=\"96\" />\n" +
                "</a>          <div props-data-classes=\"user-follow-button-footer\" data-author-follow-button></div>\n" +
                "          <a class=\"title\" href=\"/u/134bbdcf71d2\">勒克儿</a>\n" +
                "          <img class=\"badge-icon\" data-toggle=\"tooltip\" title=\"简书旅行优秀作者\" src=\"//upload.jianshu.io/user_badge/f4073b9f-96ea-48f3-ba7b-bb0bb3ad0b61\" alt=\"F4073b9f 96ea 48f3 ba7b bb0bb3ad0b61\" />\n" +
                "            <i class=\"iconfont ic-man\"></i>\n" +
                "        </div>\n" +
                "          <div class=\"signature\">玩名山大川的无反 品味道江湖的指尖</div>\n" +
                "      </div>\n";

        String content = "<html>\n" +
//                "<head>\n" + catCircleStyle +
//                "</head>\n" +
                "<body>" +SSS + "</body>\n" +
                "</html>";
        webView.loadData(content, "text/html; charset=UTF-8", null);
    }
}
