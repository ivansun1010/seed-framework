package com.ync365.seed.utils;

public class Constants {

    /**
     * 状态，通用
     */
    public static enum Status {

        Enabled(1, "启用"), Disabled(0, "禁用");

        private final int value;
        private final String content;

        private Status(int value, String content) {
            this.value = value;
            this.content = content;
        }

        public int v() {
            return value;
        }

        public String c() {
            return content;
        }

    }
    
    /**
     * 商品上下架状态
     * 
     */
    public static enum GoodsStatus {
    	
    	Enabled((byte)2, "上架"), Disable((byte)1, "下架");

        private final Byte value;
        private final String content;

        private GoodsStatus(Byte value, String content) {
            this.value = value;
            this.content = content;
        }

        public Byte v() {
            return value;
        }

        public String c() {
            return content;
        }
    }
    /**
     * 活动类型
     * 
     */
    public static enum PromotionType {
    	
    	Group((byte)1, "团购活动"),Coupon((byte)2,"红包活动"),
    	Reduce((byte)3,"满减活动"),Retrun((byte)4,"满返活动"),
    	Gift((byte)5,"满赠活动"),Seckill((byte)6,"秒杀活动");

        private final Byte value;
        private final String content;

        private PromotionType(Byte value, String content) {
            this.value = value;
            this.content = content;
        }

        public int v() {
            return value;
        }

        public String c() {
            return content;
        }
    }
    /**
     * 活动是否删除
     * @author lyh
     *
     */
    public static enum PromotionIsDelete {
    	 Enabled((byte)0, "不删除"), Disabled((byte)1, "删除");
    	 

    	  private final byte value;
          private final String content;

          private PromotionIsDelete(Byte value, String content) {
              this.value = value;
              this.content = content;
          }

          public int v() {
              return value;
          }

          public String c() {
              return content;
          }
    }
    
    /**
     * 活动状态
     * @author sunyf
     *
     */
    public static enum PromotionStatus {
    	 New((byte)0, "新建"), Begin((byte)1, "启动"), End((byte)1, "结束") ;
    	 

    	  private final byte value;
          private final String content;

          private PromotionStatus(Byte value, String content) {
              this.value = value;
              this.content = content;
          }

          public int v() {
              return value;
          }

          public String c() {
              return content;
          }
    }
    /**
     * 是否状态
     * @author sunyf
     *
     */
    public static enum Whether {
    	 Yes((byte)0, "否"), No((byte)1, "是");
    	 

    	  private final byte value;
          private final String content;

          private Whether(Byte value, String content) {
              this.value = value;
              this.content = content;
          }

          public int v() {
              return value;
          }

          public String c() {
              return content;
          }
    }
    
}
