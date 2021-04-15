package all.javalearn.test;

import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.Collectors;

/**
 * Created on 2020/7/8 11:25
 *
 * @author shudebao@limikeji.com
 */
public class Test {
    public static void main(String[] args) throws UnsupportedEncodingException, URISyntaxException {
//        executor((Executor)null);
//        List<Integer> list = new ArrayList<>();
//        List<Integer> collect = list.stream().filter(p -> p.equals(11)).collect(Collectors.toList());
//        System.out.println(1111);
//
//        LocalDateTime now = LocalDateTime.now();
//        LocalDateTime before = now.minus(1000, ChronoUnit.HOURS);
//        List<LocalDateTime> integers = Arrays.asList(now, before);
//        LocalDateTime max = integers.stream().max((a, b) -> {
//            if (a.isAfter(b)) {
//                return 1;
//            } else {
//                return -1;
//            }
//        }).get();
//        System.out.println(max);
//
//        List<Integer> integers1 = Arrays.asList(1, 2, 3, 4, 5);
//        Integer integer = integers1.stream().filter(p -> p == 6).findFirst().get();
//        System.out.println(integer);

//        String idsStr = "王赐  13177270898\n" +
//                "阮锦锦  13780021556\n" +
//                "翁良誉  18689768257\n" +
//                "任怡涵  15027728800\n" +
//                "刘石岩  17731960846\n" +
//                "赵翊  18033789802\n" +
//                "刘姝毓  18032810555\n" +
//                "王熔堉  13521735065\n" +
//                "王楚涵  13845841469\n" +
//                "岳梓含  13934183730\n" +
//                "冯艺泽  13947320524\n" +
//                "赵奕璇  18233991656\n" +
//                "胡钦洋  13357089677\n" +
//                "崔梦阳  17333651883\n" +
//                "王楚涵  18633069318\n" +
//                "张楚涵  15131937851\n" +
//                "郝匀嘉  13932167751\n" +
//                "文雅婷  17308489811\n" +
//                "张艺泽  15032061180\n" +
//                "郭濮豪  15100911566\n" +
//                "张殿文  13930994087\n" +
//                "韩名扬  13722945995\n" +
//                "赵佳晋  18103192633\n" +
//                "李玥     13911126410\n" +
//                "王木泽   17731960606\n" +
//                "孔云锐  18901111058\n" +
//                "徐依然  13833634940\n" +
//                "梁宇    13718319809\n" +
//                "汪睿雯  13913864779\n" +
//                "鲁林阳  15233918115\n" +
//                "刘芷伊  13604079489\n" +
//                "易云倩  13787125852\n" +
//                "王宥坤  13383394939\n" +
//                "张煜轩  13799497654\n" +
//                "周煜程  13091271955\n" +
//                "高瑞泽  15930051368\n" +
//                "赵梦冉  15612966863\n" +
//                "张嘉枞  15632107976\n" +
//                "霍雅姿  13784940498\n" +
//                "肖郅宸  15182992993\n" +
//                "刘中轩     15909003107\n" +
//                "李浩宇  15832957101\n" +
//                "陈依阳  13111581345\n" +
//                "任翱崭  15028147816\n" +
//                "付泽恩  14731101051\n" +
//                "薛旭  17798151606\n" +
//                "王嘉乐  18332233983\n" +
//                "张艺  13541201639\n" +
//                "孟世贤  15633083835\n" +
//                "曹靖楷  15199038310\n" +
//                "冯可扬  13832125933\n" +
//                "王子霖   13011900010\n" +
//                "周娜娜  13400189969\n" +
//                "王子依  15076194225\n" +
//                "付家豪  18633693128\n" +
//                "杨皓烁  15284293111\n" +
//                "屈芳荣  15947223834\n" +
//                "李昀倩  18635885899\n" +
//                "黄思贤  15697366922\n" +
//                "杨雨诺  13483624065\n" +
//                "陈嘉琪  19931803882\n" +
//                "王廷宇  15888611697\n" +
//                "张妤曦  18688414947\n" +
//                "刘泽翰  13473069498\n" +
//                "王菁  15032088354\n" +
//                "杨思彤  15175137969\n" +
//                "翟一理  15031900672\n" +
//                "郭嘉尚  13784894430\n" +
//                "袁铭泽  13633292292\n" +
//                "顾浩榆  18796109238\n" +
//                "郭子睿  18603217076\n" +
//                "范航源  18034219691\n" +
//                "唐宇轩  18399672839\n" +
//                "米卡依  13629931297\n" +
//                "武月涵  15030009285\n" +
//                "路畅  15333194762\n" +
//                "张鲁韵  15564366363\n" +
//                "贾婼雯  15833650806\n" +
//                "任尚美  18032124571\n" +
//                "张东阳  15131971397\n" +
//                "王佳栋  18233037175\n" +
//                "董茉涵  18101050608\n" +
//                "黑少楷  17732968028\n" +
//                "裴佳怡  13483671618\n" +
//                "徐鑫豪  18233938262\n" +
//                "张嘉旭  18600581877\n" +
//                "代诗涵  18233056131\n" +
//                "高新月  13315944567\n" +
//                "刘钰楠  17731935890\n" +
//                "张玉坤  15100891848\n" +
//                "于梓桐  13483683560\n" +
//                "苏燿阳  15383104560\n" +
//                "彭安淇  13831945176\n" +
//                "赵宁  13699204870\n" +
//                "李璐垚  15333193526\n" +
//                "路钰冉  15127965342\n" +
//                "张艺琳  15100923811\n" +
//                "许欣冉  13739697345\n" +
//                "胡雅鑫  15103299921\n" +
//                "任宇涵  13832139617\n" +
//                "李雨哲  17772611050\n" +
//                "彭晨洋  13383046046\n" +
//                "毛正玥  13513212608\n" +
//                "霍子帅  15830493667\n" +
//                "吕昕洋  18131858869\n" +
//                "范天乐  18832931551\n" +
//                "梁麦琪  13933004655\n" +
//                "胡浩语  15131345000\n" +
//                "李锦溪  15930150169\n" +
//                "王阳文馨  18031991129\n" +
//                "张佳旺  18032906772\n" +
//                "张若汐  15032621239\n" +
//                "刘诺鑫  13673230800\n" +
//                "李佳妍  13363725285\n" +
//                "王思涵  15531959528\n" +
//                "池垣硕  15094482210\n" +
//                "王施砚  18713988228\n" +
//                "方冰涵  13803193486\n" +
//                "翟一皓  13784892093\n" +
//                "于志羽  18622834131\n" +
//                "李佳贺  15931412979\n" +
//                "王瑾立  13017773738\n" +
//                "闫薪雨  15030488911\n" +
//                "崔梓妍  13463198202";
//        List<String> phones = Arrays.asList(idsStr.split("\n")).stream().map(p -> {
//            String[] split = p.split(" ");
//            return split[split.length - 1];
//        }).collect(Collectors.toList());
//        System.out.println(phones.size());
//        System.out.println(phones);
//        StringBuilder sb =new StringBuilder();
//        phones.forEach(p -> {
//            sb.append("'").append(p).append("'").append(",");
//        });
//        sb.deleteCharAt(sb.length() - 1);
//        System.out.println(sb);

        String idsStr = "166405\n" +
                "166404\n" +
                "165884\n" +
                "165851\n" +
                "165823\n" +
                "165822\n" +
                "165821\n" +
                "165820\n" +
                "165819\n" +
                "165813\n" +
                "165812\n" +
                "165811\n" +
                "179211\n" +
                "166466";
        List<Integer> ids = Arrays.asList(idsStr.split("\n")).stream().map(p -> {
            if (StringUtils.isNotBlank(p)) {
                return Integer.parseInt(p);
            } else {
                return 0;
            }
        }).filter(p -> p > 0).collect(Collectors.toList());
        System.out.println(ids);

//        String decode = URLDecoder.decode("%E7%A4%BC%E7%89%A9%E5%88%97%E8%A1%A8%2B1652%E5%8D%95%2B2021-02-03_17+08%E5%88%8636%E7%A7%92.xlsx", "utf-8");
//        System.out.println(decode);

        URI uri = new URI("https://banzhuren-assistant.oss-cn-beijing.aliyuncs.com/dev/marlon/import/express/origin/excel/2021-02-04/5c6abb13-180f-434e-ad8e-15bac67e11dd32+2021-02-04.xlsx");
        File file = new File(uri);
        System.out.println(file.exists());
    }

    private static void executor(Executor executor) {
        System.out.println(executor);
        System.out.println(1111);

        System.out.println((11 & -11) == 11);
        System.out.println((16 & -16) == 16);

        System.out.println((12 & -12) == 12);
        System.out.println((8 & -8) == 8);

        ExecutorService executorService = Executors.newFixedThreadPool(1);
        Future<?> submit = executorService.submit(new Runnable() {
            @Override
            public void run() {

            }
        });

    }
}
