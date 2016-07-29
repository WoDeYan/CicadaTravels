//package com.wang.mac.cicadatravels.ui.adapter;
//
//import android.content.Context;
//import android.support.v7.widget.RecyclerView;
//import android.util.Log;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.ImageView;
//import android.widget.TextView;
//
//import com.wang.mac.cicadatravels.R;
//import com.wang.mac.cicadatravels.model.bean.TravelsDetailsBean;
//import com.wang.mac.cicadatravels.model.bean.TravelsNeedBean;
//
//import java.util.ArrayList;
//
///**
// * Created by mac on 16/7/26.
// */
//public class TravelsDetailsAdapter extends RecyclerView.Adapter {
//    private TravelsDetailsBean travelsDetailsBean;//游记详情界面所有数据的类
//    private Context context;
//    private final int TYPE_ONE =0;
//    private final int TYPE_TWO =1;
////    1private ArrayList<TravelsDetailsBean.TripDaysBean> tripDaysBeanArrayList;//trip_days的集合
////    private ArrayList<TravelsDetailsBean.TripDaysBean.NodesBean> nodesBeanArrayList;//nodes的集合
////    private ArrayList<TravelsDetailsBean.TripDaysBean.NodesBean.NotesBean> notesBeanArrayList;//notes的集合
////    private ArrayList<TravelsDetailsBean.NotesLikesCommentsBean> notesLikesCommentsBeanArrayList;//notes_likes_comment的集合
////    private TravelsDetailsBean.TripDaysBean.NodesBean.NotesBean.PhotoBean photoBean;//photo类
////    private TravelsNeedBean travelsNeedBean;
//    private ArrayList<TravelsNeedBean> beanArrayList;
//
//    public TravelsDetailsAdapter(Context context) {
//        this.context = context;
//    }
//
//    public void setTravelsDetailsBean(TravelsDetailsBean travelsDetailsBean) {
//        this.travelsDetailsBean = travelsDetailsBean;
//        Log.d("wwj1", travelsDetailsBean.getName());
//        beanArrayList = new ArrayList<>();
//        tripDaysBeanArrayList = new ArrayList<>();
//        nodesBeanArrayList = new ArrayList<>();
//        notesBeanArrayList = new ArrayList<>();
//        notesLikesCommentsBeanArrayList = new ArrayList<>();
//        photoBean = new TravelsDetailsBean.TripDaysBean.NodesBean.NotesBean.PhotoBean();
//        travelsNeedBean = new TravelsNeedBean(null,null,null,null,null);
//        //把喜欢与评论加到数据中
//        for (int i = 0; i < notesLikesCommentsBeanArrayList.size(); i++) {
//            travelsNeedBean.setLoveCount(travelsDetailsBean.getNotes_likes_comments().get(i).getLikes_count());
//            Log.d("wwj2", travelsDetailsBean.getNotes_likes_comments().get(1).getLikes_count());
//            travelsNeedBean.setCommentCount(travelsDetailsBean.getNotes_likes_comments().get(i).getComments_count());
//        }
//        //把第几天 , 日期 , 标题 ,内容加到数据中
//        //根据数据接口一层一层for循环加入数据
//        for (int i = 0; i < tripDaysBeanArrayList.size(); i++) {
//            travelsNeedBean.setDays(travelsDetailsBean.getTrip_days().get(i).getDay());
//            travelsNeedBean.setTripData(travelsDetailsBean.getTrip_days().get(i).getTrip_date());
//            for (int j = 0; j < nodesBeanArrayList.size(); j++) {
//                travelsNeedBean.setTitle(travelsDetailsBean.getTrip_days().get(i).getNodes().get(j).getEntry_name().toString());
//                travelsNeedBean.setComment(travelsDetailsBean.getTrip_days().get(i).getNodes().get(j).getComment().toString());
//                for (int k = 0; k < notesBeanArrayList.size(); k++) {
//                    travelsNeedBean.setDescription(travelsDetailsBean.getTrip_days().get(i).getNodes().get(j).getNotes().get(k).getDescription());
////                    travelsNeedBean.setImgUrls(travelsDetailsBean.getTrip_days().get(i).getNodes().get(j).getNotes().get(k).getPhoto());
//                }
//            }
//        }
//        //把网址传入到数据
//        travelsNeedBean.setImgUrls(photoBean.getUrl());
//        beanArrayList.add(travelsNeedBean);
//        notifyDataSetChanged();
//    }
//
//    @Override
//    public int getItemViewType(int position) {
//        if (beanArrayList.get(position).getTitle()!=null){
//            return TYPE_ONE;
//        }else {
//            return TYPE_TWO;
//        }
//    }
//
//    @Override
//    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//        return null;
//    }
//
//    @Override
//    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
//
//    }
//
//    @Override
//    public int getItemCount() {
//        return 0;
//    }
//    class TravelsHolder extends RecyclerView.ViewHolder{
//        private TextView travelsTheDayTv,travelsYNDTv,travelsWeekTv,travelsTitleTv,travelsCommentTv,travelsSmallTitleTv,travelsLoveCountTv,travelsCommentCountTv,travelsDescriptionTv;
//        private ImageView travelsPhotoIv;
//        public TravelsHolder(View itemView) {
//            super(itemView);
//            travelsTheDayTv = (TextView) itemView.findViewById(R.id.travels_the_day_tv);
//            travelsYNDTv = (TextView) itemView.findViewById(R.id.travels_year_mouth_day_tv);
//            travelsWeekTv = (TextView) itemView.findViewById(R.id.travels_week_tv);
//            travelsCommentTv = (TextView) itemView.findViewById(R.id.travels_comment_tv);
//            travelsDescriptionTv = (TextView) itemView.findViewById(R.id.travels_description_tv);
//            travelsTitleTv = (TextView) itemView.findViewById(R.id.travels_title_tv);
//            travelsSmallTitleTv = (TextView) itemView.findViewById(R.id.travels_small_title_tv);
//            travelsLoveCountTv = (TextView) itemView.findViewById(R.id.travels_love_tv);
//            travelsCommentCountTv = (TextView) itemView.findViewById(R.id.travels_comments_count_tv);
//            travelsPhotoIv = (ImageView) itemView.findViewById(R.id.travels_photo_iv);
//        }
//    }
//}
