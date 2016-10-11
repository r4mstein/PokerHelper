package ua.r4mstein.pokerhelper.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import ua.r4mstein.pokerhelper.R;

public class ItemFragment extends Fragment {

    public static final String OPEN_RAISE = "OPEN_RAISE";
    public static final String COLD_CALL = "COLD_CALL";
    public static final String THREE_BET = "3BET";
    public static final String VS_THREE_BET = "VS_THREE_BET";

    private String mOpenRaise;
    private String mColdCall;
    private String mThreeBet;
    private String mVsThreeBet;

    private static String[] openRaise = new String[]
            {
              "AA-33; AKo-AJo; KQo; AKs-ATs; KQs-KTs; QJs-QTs; JTs-J9s; T9s; 98s; 87s; 76s; 65s;",
              "AA-22; AKo-ATo; KQo; AKs-A7s; A5s; KQs-KTs; QJs-QTs; JTs-J9s; T9s-T8s; 98s-97s;" +
                      " 87s-86s; 76s-75s; 65s; 54s;",
              "AA-22; AKo-ATo; KQo-KJo; QJo; AKs-A2s; KQs-K6s; QJs-Q7s; JTs-J8s; T9s-T8s;" +
                      " 98s-97s; 87s-86s; 76s-75s; 65s-64s; 54s;",
              "AA-22; AKo-A2o; KQo-K7o; QJo-Q9o; JTo-J9o; T9o-T8o; 98o; 87o; AKs-A2s; KQs-K2s; " +
                      "QJs-Q2s; JTs-J5s; T9s-T6s; 98s-96s; 87s-85s; 76s-74s; 65s-64s; 54s-53s; 43s;",
              "AA-22; AKo-A7o; KQo-K9o; QJo-Q9o; JTo-J9o; T9o; 98o; AKs-A2s; KQs-K2s; QJs-Q4s;" +
                      "JTs-J7s; T9s-T7s; 98s-97s; 87s-86s; 76s-75s; 65s-64s; 54s;",
              "Not for this position"
            };
    private static String[] coldCall = new String[]
            {"Not for this position",
             "<b>Contra UTG:</b> QQ-55; AKo-AQo; AQs-ATs; KQs-KJs; QJs; JTs; T9s; 98s; 87s;",
             "<b>Contra UTG:</b> QQ-44; AKo-AQo; AQs-ATs; KQs-KJs; QJs; JTs; T9s; 98s; 87s;<br>" +
                 "<b>Contra MP:</b> JJ-44; AKo-AQo; AQs-ATs; KQs-KTs; QJs-QTs; JTs; T9s; 98s; 87s; 76s;",
             "<b>Contra UTG:</b> QQ-33; AKo-AQo; AQs-ATs; KQs-KTs; QJs-QTs; JTs-J9s; T9s; 98s; 87s; " +
                     "76s; 65s; 54s<br>" +
                 "<b>Contra MP:</b> JJ-33; AKo-AQo; AQs-ATs; KQs-KTs; QJs-QTs; JTs-J9s; T9s; 98s; 87s; " +
                     "76s; 65s; 54s<br>" +
                 "<b>Contra CO:</b> AA*; TT-22; AKo*-AJo; KQo; AQs-A8s; KQs-KTs; QJs-QTs; JTs-J9s; " +
                     "T9s-T8s; 98s-97s; 87s-86s; 76s-75s; 65s; 54s",
             "<b>Contra UTG:</b> QQ-88; AKo*; AQs; KQs;<br>" +
                 "<b>Contra MP:</b> JJ-77; AKo*-AQo; AQs; KQs;<br>" +
                 "<b>Contra CO:</b> TT-88; AQo-AJo; KQo; AJs-ATs; KQs-KJs; QJs;<br>" +
                 "<b>Contra BTN:</b> 99-66; KTo; QJo-QTo; A9s-A8s; KTs-K9s; QJs-QTs; JTs; T9s;",
             "<b>Contra UTG:</b> QQ-44; AKo-AQo; AQs-ATs; KQs-KJs; QJs; JTs;<br>" +
                 "<b>Contra MP:</b> JJ-22; AQo; AQs-ATs; Kqs-KJs; QJs; JTs; T9s; 98s; 87s;<br>" +
                 "<b>Contra CO:</b> TT-22; AQo-AJo; KQo; AJs-ATs; KJs-KTs; QJs-QTs; JTs-J9s; T9s; 98s;<br>" +
                 "<b>Contra BTN:</b> 99-33; A9o-A2o; KTo-K7o; QJo-Q8o; JTo-J9o; T9o; 98o;  A8s-A2s; " +
                     "KTs-K5s; QJs-Q7s; JTs-J8s; T9s-T8s; <br>" +
                 "<b>Contra SB:</b> TT-22; ATo-A2o; KJo-K7o; QJo-Q8o; JTo-J8o; T9o-T8o; 98o-97o; 87o; 76o;" +
                     " ATs-A2s; KJs-K2s; QJs-Q2s; JTs-J4s; T9s-T5s; 98s-95s; 87s-85s; 76s-74s; " +
                     "65s-64s; 54s-53s; 43s"
            };
    private static String[] threeBet = new String[]
            {
             "<b>Contra UTG IP:</b> AA-KK; AJo; KQo; AKs; A5s-A4s;<br>" +
                     "<b>Contra UTG OOP:</b> AA-KK; AKo*; 44-33; AKs; T9s; 98s; 87s; 76s; 65s;",
             "<b>Contra MP IP:</b> AA-QQ; AJo; KQo; AKs; A5s-A4s; T8s; 97s;<br>" +
                     "<b>Contra MP from SB:</b> AA-QQ; 66-44; AKo; AKs-AQs; JTs; T9s; 98s; 87s; 76s;<br>" +
                     "<b>Contra MP from BB:</b> AA-QQ; AKo; AKs-AQs; QTs; J9s; T8s; 98s-97s; 87s; 76s; 65s; 54s;" ,
             "<b>Contra CO IP:</b> AA*-JJ; AKo*; ATo; KJo; QJo; AKs; A7s-A2s;<br>" +
                     "<b>Contra CO from SB:</b> AA-JJ; 55-44; AKo; AKs-AQs; KTs; QTs; JTs-J9s; T9s-T8s;" +
                            "98s-97s; 87s; 76s; 65s; 54s;<br>" +
                     "<b>Contra CO from BB:</b> AA-JJ; 44-22; AKo; AKs-AQs; A5s-A4s; K9s; Q9s; T8s;" +
                            "97s; 87s-86s; 76s-75s; 65s-64s; 54s;",
             "<b>Contra BTN from SB&BB:</b> AA-TT; 22; AKo-ATo; KQo-KJo; AKs-A9s; KQs-KJs; K4s-K2s; " +
                     "Q6s-Q2s; J7s-J6s; T7s; 98s-96s; 87s-85s; 76s-75s; 65s-64s; 54s-53s; 43s;",
             "<b>Contra SB from BB:</b> AA-TT; 22; AKo-ATo; KQo-KJo; AKs-A9s; KQs-KJs; K4s-K2s; " +
                     "Q6s-Q2s; J7s-J6s; T7s; 98s-96s; 87s-85s; 76s-75s; 65s-64s; 54s-53s; 43s;",
             "Not for this position"
            };
    private static String[] vsThreeBet = new String[]
            {
            "<b>Call contra 3b IP:</b> KK-TT*; AKo-AQo*; Aks-AQs; KQs;<br>" +
                    "<b>4bet contra 3b IP:</b> AA; 98s; 87s; 76s;<br>" +
                    "<b>Call contra 3b OOP:</b> KK-TT*; AKo-AQo*; AKs-AQs; KQs;<br>" +
                    "<b>4bet contra 3b OOP:</b> AA; AJs; ATs; 76s;",
            "<b>Call contra 3b IP:</b> QQ-TT; AKo-AQo*; AKs-AQs; KQs;<br>" +
                    "<b>4bet contra 3b IP:</b> AA-KK; AKs; 98s; 87s; 76s; 65s; 54s;<br>" +
                    "<b>Call contra 3b OOP:</b> AA*; QQ-TT; AKo-AQo; AKs-AJs; KQs; QJs;<br>" +
                    "<b>4bet contra 3b OOP:</b> AA*-KK; 98s; 87s; 76s; 65s;",
            "<b>Call contra 3b IP:</b> AA; JJ-99; AKo*-AQo; KQo; AQs-AJs; KQs; KJs; QJs;<br>" +
                    "<b>4bet contra 3b IP:</b> KK-QQ; AKo*; AKs; T9s; 98s; 87s; 76s; 65s;<br>" +
                    "<b>Call contra 3b OOP:</b> JJ-99; AKo-AJo; KQo; AQs-ATs; KQs-KTs; QJs-QTs; JTs; T9s; 98s; <br>" +
                    "<b>4bet contra 3b OOP:</b> AA-QQ; AKs; A8s-A5s; 87s; 76s;",
            "<b>Call contra 3b:</b> AA; TT-77; AQo-ATo; KQo-KTo; QJo; AQs-A7s; A5s-A2s; KQs-K9s; " +
                    "QJs-Q9s; JTs-J9s; T9s-T8s; 98s-97s; 87s; 76s; 65s;<br>" +
                    "<b>4bet contra 3b:</b> KK-JJ; AKo; AKs; A6s; A4s-A2s; K8s-K4s; Q8s-Q7s;",
            "<b>Call contra 3b:</b> AA; TT-77; AQo-ATo; KQo-KJo; AQs-A9s; KQs-KTs; " +
                    "QJs-QTs; JTs-J9s; T9s; 98s;<br>" +
                    "<b>4bet contra 3b:</b> KK-JJ; AKo; AKs; T9s-T8s; 98s-97s; 87s; 76s; 65s; 54s;",
            "Not for this position"
            };

    public static ItemFragment newInstance(int page) {
        Bundle args = new Bundle();
        args.putString(OPEN_RAISE, openRaise[page]);
        args.putString(COLD_CALL, coldCall[page]);
        args.putString(THREE_BET, threeBet[page]);
        args.putString(VS_THREE_BET, vsThreeBet[page]);

        ItemFragment fragment = new ItemFragment();
        fragment.setArguments(args);

        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mOpenRaise = getArguments().getString(OPEN_RAISE);
        mColdCall = getArguments().getString(COLD_CALL);
        mThreeBet = getArguments().getString(THREE_BET);
        mVsThreeBet = getArguments().getString(VS_THREE_BET);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.item_fragment, container, false);

        TextView tvOpenRaise = (TextView) view.findViewById(R.id.tvOpenRaise);
        tvOpenRaise.setText(Html.fromHtml(mOpenRaise));

        TextView tvColdCall = (TextView) view.findViewById(R.id.tvColdCall);
        tvColdCall.setText(Html.fromHtml(mColdCall));

        TextView tvThreeBet = (TextView) view.findViewById(R.id.tv3Bet);
        tvThreeBet.setText(Html.fromHtml(mThreeBet));

        TextView tvVsThreeBet = (TextView) view.findViewById(R.id.tv_vs3Bet);
        tvVsThreeBet.setText(Html.fromHtml(mVsThreeBet));

        return view;
    }
}
