package com.cloud.secure.others;


import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Random;

import javax.imageio.ImageIO;

import org.apache.commons.codec.binary.Base64;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class MimicProduction {
	final static String data="_9j_4AAQSkZJRgABAQAAAQABAAD__gA7Q1JFQVRPUjogZ2QtanBlZyB2MS4wICh1c2luZyBJSkcgSlBFRyB2NjIpLCBxdWFsaXR5ID0gODUK_9sAQwAFAwQEBAMFBAQEBQUFBgcMCAcHBwcPCwsJDBEPEhIRDxERExYcFxMUGhURERghGBodHR8fHxMXIiQiHiQcHh8e_9sAQwEFBQUHBgcOCAgOHhQRFB4eHh4eHh4eHh4eHh4eHh4eHh4eHh4eHh4eHh4eHh4eHh4eHh4eHh4eHh4eHh4eHh4e_8AAEQgBLgEsAwEiAAIRAQMRAf_EAB8AAAEFAQEBAQEBAAAAAAAAAAABAgMEBQYHCAkKC__EALUQAAIBAwMCBAMFBQQEAAABfQECAwAEEQUSITFBBhNRYQcicRQygZGhCCNCscEVUtHwJDNicoIJChYXGBkaJSYnKCkqNDU2Nzg5OkNERUZHSElKU1RVVldYWVpjZGVmZ2hpanN0dXZ3eHl6g4SFhoeIiYqSk5SVlpeYmZqio6Slpqeoqaqys7S1tre4ubrCw8TFxsfIycrS09TV1tfY2drh4uPk5ebn6Onq8fLz9PX29_j5-v_EAB8BAAMBAQEBAQEBAQEAAAAAAAABAgMEBQYHCAkKC__EALURAAIBAgQEAwQHBQQEAAECdwABAgMRBAUhMQYSQVEHYXETIjKBCBRCkaGxwQkjM1LwFWJy0QoWJDThJfEXGBkaJicoKSo1Njc4OTpDREVGR0hJSlNUVVZXWFlaY2RlZmdoaWpzdHV2d3h5eoKDhIWGh4iJipKTlJWWl5iZmqKjpKWmp6ipqrKztLW2t7i5usLDxMXGx8jJytLT1NXW19jZ2uLj5OXm5-jp6vLz9PX29_j5-v_aAAwDAQACEQMRAD8A-y6SlooATNBNI7BFLMQAKx9Q1UKdkXPvUTmoK7JlNRWppzXEcQyzCqUmpoDhcmsR53kJLMTmmb_euWWIb2OeVd9DYbU3PQU06jL7Vlb_AHo3-9R7aXcj2rNT-0Zfaj-0Zfasvf70b_ej28u4e0Zqf2jL7Uf2jL7Vl7_ejf70e3l3D2jNT-0Zfaj-0Zfasvf70b_ej28u4e0Zqf2jL7Uf2jL7Vl7_AHo3-9Ht5dw9ozU_tGX2o_tGX2rL3-9G_wB6Pby7h7Rmp_aM3t-dH9oy-1Ze_wB6N_vR7eXcPaM1P7Rl9qP7Rl9qy95_vUb_AHo9vLuHtGan9oy-1H9oy-1Ze8_3qN_vR7eXcPaM1P7Rl9qP7Rl9qy9_vRv96Pby7h7Rmp_aMvtR_aMvtWXv96N5_vUe3l3D2jNT-0Zfaj-0Zfasvf70bz_eo9vLuHtGao1GXPapE1Mg_MKxt_vRvP8Aeo9vIaqtHSQ38LnrVtGUjK81yG_3qza6hNCeTuFaxxOupca_8x0_Wiq1ldpcKCDz6VYrqTTV0dCd9UOooopjAUwnHoAKfWT4hvPs1ttU4d-BUTkoRbZM5cquUta1IvI0ETfKOpFZBkyck5qDeSSSck0bhXkzqubuzzpVOZ3ZP5lHmVBuFG4VPMQ5difzKA-ag3Ub6XMPmJ_MoD5qvvFLuo5g5icvijzBUG6jcKfMHMT-YKPMqDcKTeKXMHMWA9AkzVfeKXcKOYOYsF6TzKg3j1o3CnzBzE4kpd9V99G-lzBzE_mUeZUG4UbhRzCUifzBR5gqDcKNwo5h8xPv4zR5gqDfRuo5g5ifzBR5lQbhRuFPmDmJ_MFHmCoNwo3ClzBzE5kxR5gqDcKNwo5g5ifzBQXxVfeKXdRzCvqW7a7eCQOjYrq9OvEuoN6n5h1FcTuFXNHvja3ikn5G4YV0YevySs9jelV5XbodqOlFNRgygjnIzS16h3iHgCuL8R3PnanIoJ2x_KP61187bImb2rzm4m8y4kkJ-8xP61w46doJHJi5WikSb6C1V99G-vKuefzFgPijfVffRvp8wXLG-jfVffRvpXDmJ93el31X30b6Lhcsb6N9V99G-nzBcsb6N2Oar76N9K4XLG7Jo31X30b6akFyfdzml31X30b_AHo5guWN9G7mq--jf70rhcsb6N9V9_vRvpqQXLG-jfVffRv96VwuWN9G-q--jfRcLljfRvqvvo30-YLljfRvqvvo30cwXLG8_wB6jfVffRvo5guWC2aN9V99G-lcLljfnijdiq--jfT5g5jvfD1x9o0yJicsvyn8K0h0rl_BM-Y5ouwYH9K6lele5h5c1NM9alLmgmUdXfZZuQccV5sX5Neia-f9AkPtXmZfmuDMtOU5Mc9ixvo31X30b68rmOC5Y30b6r76N9HMFyxvo31X30b6OYXMixvo31X30b6L3Hcsb6N9V99G-jmFzIsb6N9V99G-jmHzFjfRvquXAGS2BUttBdXRAtrWef3RCR-fSqipS2Q0nLYfvo3HGavQeHNam_5dY4h6yyAfyzV-LwfqLD95d2qf7qs3-FbxwtaX2TWNCpLZGFvo8w10i-DJj97U0H0g_wDsqD4MlA41Rfxg_wDsqr6lW7F_VavY5vfRvrdfwdfg_JfQMPeMj-pqtP4W1qPlFtpv9yQg_qBUvC1l9kl4er2MvfRvqS60zVLYEz6fcqo6sq7x_wCO5qkJFLFQeR1BOCKxlGcfiVjKScd0Wd9G-q5bHejfUcxNyxvo31X30b6OYLljfRvqvvo30XC5Y30b6r76N9HMwuWN9G-q--jfRcLljfRvqvvo30cwXOn8FSYvJFPQ4rtweOtef-DGzfsPYV36fdFe_gv4SPXwv8JGb4hJFhJ_u15fvr1DxBzp8n-7XlDNhjXFmr0icmYO3KT76N9V99G-vH5mebzMsb_pRvqvvo30czDmZY30b6r76N9HMxXLG-jfVffRvo5mPmZY30m-q5f6-3vXUeH_AAndXoS41EvbQHkRj77fX-6P1rejSnWdoI0pUpVXaJhQJNczCC2hkml_uouT-PoK6TTfBt7Nh7-dbZTzsj-ZvxPQfrXY6fp9np8AgtIEjQc4A5PuT3q2Ogr2KWXwjrLVnp08FCPxasyLDw3pVnhktUeQfxy_Of1rWRAowAB9BT6Wu6MIxVkjsUVFWQ0rzQAadRVlCAUUtFADcUY9qdRQAzb6VUvdNsr1dtzaRS-7Lz-fWr3FFS4piaTOQ1HwXbvuawuHtz2RzvX9eR-dcvqmlajphP2q2Pl_89U-ZPz7fjXqp-7TDGjLhgCD1BrjrYCnU1WjOaphKc9tGePhwRkYxRv-ldxr3hC2uQ0-nFbafOSuP3bfh2_CuGvba5sbg295C8Mo7How9Qe4rx8RhqlDfY8ytQnS32F30b6r76N9cvMzn5mWN_0o31X3E96N1HMw5mWN9G-q-6jfRzMOZljfRvqvvo30czDmZ1Hgc51Fz7CvQk-6K848BnOoSfQV6Sn3RX0mCd6CPcwjvSRl-If-PCXntivIi_XmvXfEODYSfSvGy2DXBnDtyHHmTty_MmDY70u_3qvvo314nMeTcsb_AHo3-9V99G-nzBcn3-9AbHeoN9G-jmC5OX460-3WWeZIII2klkO1EXqTVZCzsqRqWZiAoHUmvT_BXh1NLthdXKBr2QfMeuwf3R_WuvCYaVefkdOGoSrTt0G-FPC8enYur0LNdnkd1i9h7-9dUvSjA9aWvpqdONOPLE9-nTjTjaItFFFaFhRRRQAUlLRQAUUUUAFFFFABRRRQAUUUUAIazdc0m01e3MF1HnAyjjhkPqDWn2ppAqZRUlZiaTVmePa9pd3o939nuBuRv9VKBw4_ofas8PxzXsOt6XbapYPa3KZU8qw6qexHvXkWr2VzpeoS2VwPmTo3Z1PQivncdhPYvmj8J4eLwzpO62I9-aXf71XDUb683mOG5Y3-9G_3qvvo30cwXJ93Oc0u-q--jfRzBc674fEnUJfQAV6SOgrzP4cnN_Nz2X-tel19TlzvQj8z6LBfwkZ3iH_jwkPtXihbJJr2vxD_AMg-T6V4dvzyOQelednT-A4c0dlH5k2fejPvUO40bjXg3R5FybPvRn3qDfilDUXQXJc-9Ln3qHJqzpdrLf6jBZQ_fmcID6DufyyacU5OyHFczSR2nwy0QTynWblMohK24Pc92_oPxr0cLgVW062is7OG1hXbHGgVR9Ks5FfZYahGhTUT6fD0VSgooM_SjNZ-r6vp-k2j3Wo3cVvCo5Zzj8vWvONX-Nvh21naOytru8wfvgBVP0pV8dh6H8SaRNbF0aH8SSR6ru9qcDXkFp8c9DkcC5028hU91Ktiu88K-MtA8SL_AMS2_SSQDJiY4cfhWdDMsLXfLCabIo46hWdoTTZ0tFNDA0juqKWY4Uck123OsXdzSdT0rznXvi94W0y-azja4vGQ4d4VBUH6k810_hDxbo_ii0afS7jeUxvjYYZPqK5aeNoVJ-zjNOXY5oYujUnyRkmzoqKTNDHArrOkbnAozkcCuL8afEjw74ZuTaXUsk90BlooQCV-uelO8FfEbw74ouPslpM8N1jIhmABb6etcn17Dup7LnXN2OZYuj7T2fMr9jtKWmhgaCwFdZ0geR60m7iuV8WePfDfhvMd_fKZ8f6mL5n_AC7fjXET_HXSFlIh0m7kTP3mcA_lXBWzPC0Xyzmkzjq4_D0nac0mexZpM_SvMdH-M_he8lWK7FxZE_xSKCo_EV6Hp2o2eo2q3VlcRzwv910bINa4fGUK_wDDkmaUcVSr_wAOSZdNcr8QdFGpaUbmFM3VuCyY6sO611GQeBQwypBFa1qaqwcH1NakFOLizwENx1pc-9anjbTv7K8R3EKLiKU-bH9G6j8DmsTfzXxlWDpTcJdD5epF05uL6E-fejPvUG6jfWd0Z3J8-9G73qDfRuouh3O1-Ghzf3HsF_rXpwORXlvwvYHULgZyQqn-depqDtr67LP93ifR4B3oozfEX_HhJx2r5o0TWlCi1u2wQcJIen0NfS_iHmxk-lfJD_fI968LiSrKm4OPn-h5OeTlDka8zvw-QCORS7q4vT9Tu7MBUffH_cbkfh6VuWmuW0wAlzC_v0_OvBp4mEzx4YiMjY3UgaoUlV13I6sp7g5pd9bqS6G1yYvXa_CSy-0azcXzLlbeLYvszf8A1gfzrhC2a9c-EFuI_Dcs-OZ7hj-AAH9K9PKoKpiFfpqd2XQ56yv01OyxgGqWtahb6XplzqF04WG3jaRz7AVoHpXnX7QdxJB8OLzyiR5ssUbEehYV9NiqvsaE5roj3sRV9lSlPsjwXx54u1HxXrMt3dSssAYiGEH5UXtx6-9YFtBPdSiK2glnk67I0LH8hUVfRf7O8WjL4PElv5B1BpGNycjf1O0euMYr86wWHlmWJaqTs3rc-HwtCWYYhqpLV6nz5eWV3ZMBe2lzbMennRMmfzq54Wl1GLxFYf2U0gvDOixBOpJNfYV9Y2d_A0F5aw3ELDBSVAwP4GsvRfB3hfSL1r3TNEs7a4P_AC0ROR9PT8K96PDLhVUo1NF5ansxyBwqJxnp-JuxfcGa4_4y6i-nfDzU5Y5DHJIghQjrlyF_kTXZ4xxXkv7TV75PhGys1bDXF1kj1Cqf6kV9BmVT2WEnLyf-R7WPn7PDTkux88Hk5Jya7D4P602ieO9PlMpWC4k8iYZwCG4GfoSDXH88cZNOido5UkQ4ZWDKfpX5phq0qVWNRdGfA0KjpVVUXRn26vPOaz_EWox6Tol5qEhGy3haQ59hwPzqr4K1Rda8L6dqYIJmgVn9mxhh-YNcX-0Vq_2HwStijYkvplQgf3F-Y_yFfpuJxKhhZVk-lz7-viIww7qra1z52v7ue8vZru4kaSWVy7OTySTT9EvpdM1a1v4XZHglWQFT6HNVOnQE8UdDX5fGrJVOfqfn0ZtVOfqfbVrIs0EcynIdQwP1Fef_ABs8ayeGNHSzsWA1C8BCN_zzXu319K6P4b3v9oeBdHuyclrVAT7qNp_lXhP7RNxJL8Q5IXJ2Q20SoO3IJP8AOv0HNcbKjgPaQert-J9rmOLdLB-0hu7fieeXE81zM09xK0kjnczMckn1qa203UrqIzWun3dxEP444WZfzAqTw8llJr9hHqJAszcRifJ42bhn8MV9h6UtitjEtiIBbBBsEeNuO2MV8tlOVLMOaU52t9587l2XLG8zlK1j4vkVo3KOpR1-8rDBFez_ALMcuoteaohaQ6cka8H7olz298Z_SvXNb8LeHtb_AOQppFpct2Z4xu_Mc1e0XR9O0ezFpplnDawLyEiTAz6-9e9l-QTwmIVTnukezgsmlhq6qc90i8v3qcaWivqD6A8--MFkGsLTUFHzRSGNj7N_9cfrXmm6vZ_iLAJ_CN8McookH_ASDXiW6vk85hy1790fPZnHlrX7olLUBvrUW_1qC5v7W2z5syg-g5P5V5Dkluea5Jbl3dVa_v7ezi3zPz2UdTWHfeIJGBS0TZ_ttyfyrFlkklcvK7Ox6knNclTGKOkdzmqYlLSJ618C7yS-1fVJ344iCrn7o-bivbQa8K_Z6_4_dR_7Zf8As1e6c4H0r7nI25YODfmfV5Q3LDRb8_zM_X8_YJP92vkpwS7cd6-tPEJ_0CQe1fJzD5j9TXi8T7Q-Z5uf_Y-ZHt9qMH0p-KXFfInzQQyzQnMUjof9k4q_BrN2gAkVZR78H9KoYoxVxnKOzKU5LZm7DrVu2PMR4_1r3_4USRy-BbCWI5V_MOfX52r5ixX0j8EnDfDuwUfwNKp_7-Mf619Lw5XlOvKMu3-R7mSVZSrNS7f5Hak8Cub-IWgnxJ4Sv9JUhZJY8xMegkXlc_iBXS8YppGetfY1KcakHCWzPp6kFUi4y2Z8T6lY3WnX01jfW8kFxC22SNxgg_1HvTtN1G-02fz7C7mtpB0aNitfWPi7wP4e8UxD-1bIGZVwlxGdkqj_AHh1-hyK8o8QfAq-jZn0PWI51zxDdJtb_vpcj9BXwuL4fxNCXNQ1X4nyGIyTEUZc1HVfiYXh74xeKdOKpdvFqEQ4IlGG_MV6x4G-KOh-I2S1lJsb1uPLlPysfZq-e_E3hTxB4akC6zpctujHCzAh42-jDj88GsaN2ikDoxV1OQQcEGsaGcY3BT5at35Mzo5ni8LPlqa-TPt0EN0NeBftO3xfWtI08H_VQPKw92bA_wDQa7_4IeJ5vEfhEC8cvd2b-TKxPLDGVY_y_CvG_j1eC6-JF9HuytskcQ54zsBP6k17ud4yNTLlOO07f5nsZrio1MCpx2lYwPh5YjUfG-j2jKGVrpCynoQp3H-VV_F-mNo3ijU9MYYFtcuqH1TOV_TFdV-z9afafiRaykZFvBJKfy2_zatT9pLSPsfjC31RFwl_B8x_204P6Fa-bWD5sudZbp_hseAsNzYB1e0vwOz_AGbNY-1-FrnSpGzJZTbkH-w4yP1Brh_2jtW-2eMYtNjfMdjAFPP8bcn9NtUfgNra6R418mZ9sF5A8bE9AQNwP_juPxrkPFGpPrHiK_1OQkm4ndxnsCeB-XFdmJzHnyyFK-t7P0R0V8bzZdCnfW9vkjovhT4eOvX2qs0e5LbTpmH_AF0ZSqj9T-VcVxivon9nDSBa-DrnUpEG--mIUkdY04H67q8C1u1NjrN7ZnOYLh4-fZiK48dhPY4SjU6u9_0_AwxeF9lhac3u7_8AAPo79ni9-0_DmGBjk2txJF-BbcP_AEKuV_aO8K3U88HieyhaWOOLybsKMlQOVf6ckH8Kk_ZfvSbXWdOLfckjmUfUEH-Qr2mSNJU8tgCpGCCMgj0r6vDUIZhlsKcu35H0eHoxxuAhCXb8UfEfuPzre8P-L_EWh7f7P1SeJB_yzLblP4GvdvFvwc8M6vLJc2Bl0q4bJPkAGMn_AHD0_DFea6_8GfFenh3097bVI15_dt5cmP8Adbj8jXzdXJ8dg5c1NN26o8KpleMwsuaGvmv8ja8M_HC-iKxa5YJOneWE7W_LpXsfhbxHpHiOxF3pV0sq_wASdGQ-47V8f39pdWN09re28ttcRnDxyIVZfzrY8B-Jbvwx4ht76CRvKDATpnh0PUV04DPsRRqKniNV-KNsFnNanNQrarz3R9hL160p6VDayrNCkqMGR1DAjuD0qY9K-5i-ZXPr0YnjNlj8Kas7glVtJSfwU180za43_LGD8WNfRfxMnFt4F1eRiBm2dBn1Ybf618vAcV8hxLWlCrCMex81nlVqpGK7E8-oXs5O-YqPReKqkEnJqTFGK-VcnLdnzzbe5Hj2o2-1SYpMVIj1D9nzi-1L6Rf-z17qK8L_AGfuL7UvpF_7NXuY6dK_Rsi_3KHzPt8o_wB1iZ3iHmwk_wB2vk-T77cd6-sPEI_0CTH92vlNh8x-pryOJ9qfzPMz7aHzIefSl59Kkx7UY9q-RsfOWI-fSj8Kkx7UY9qLBYix-Fe-_s_Xay-D5rfPMFywx7EA14Pj2r1P9nzUBFq2oaYxwJoxMoPcqcH9D-le1kNRUsXG_W6PTyefJiVfroe20x5FQEuQFAySe1BOa4H493N_a_Du6ksGdf3qLOydVjJ5_pX3eIrexpSna9lc-vr1fZU5TteyOwttZ0qeYxQajaySZxsWQE5q9uDDIr4linnik3xSyI4OQwYg11OlfEbxhpsIht9XmdB0EoD4_OvmKPFMHpVjb0PApcQ03_Ejb0Poz4lvp6-CtWOo7GhNq64YcFiPl_HOK-Rj1xW94l8W-IPESqmqX8k0a8iMcKD64FYtrBNdXMVtbQvNNKwSONBksT0AFeJm-PjmFWPs47aeZ5GZ41Y6qvZrbT1PcP2X0kWw1uUg-WZIlB7ZCsT_ADFeR-N7z-0PF-rXmciW7kKn23ED9BX0Z4H0E-CfhvNHNg3awSXNyV6eZtzgfQAD8K-XJGLyM5PJOTXTm0JYfB0aEt9Wb5nTlQwlKi99T1_9mC0365q98RnybdIgfQuxP_stdj-0XpH2_wADi_VMy6fMsme-xjtb-YP4Vn_sxWfleG9SvSOZ7sID6hVH_wAUa9N8S6fHq-g3umycrcQPH9Mjg17-X4VTytU_5k_x2PZweG58uVN9Uz4zjkkicPE7Iw6EHkUiq7uERSzMcKB3NOuYZLe4kt5lxJG5Rx6EHBrqPhJpB1n4g6VbMu6KOXz5eP4UG7-YA_GvhqFGVSvGl1bsfH0aTnWjT7ux9N-DdLXRvC-naWoA-zwKje7Y-Y_nmvmT4uWn2L4ka3CRgNceYPo6hv6mvrQDaMCvmr9o20-z_EATgYFzaRv-IJX-lfZ8RUEsFG32Wv8AI-szyko4SNvstEv7N14IPHM1qxwt1auB9VIP8s19D31_ZWK-ZeXUNup4BkcKD-dfKfwkvDZfETRZFziS4ERx6MCv9a3_ANoa51A-PZLe4eRbVII2tlycEEfMf--siuLLMy-qZc52vZ2-85cvx_1fAuSV7O33n0faX1ndx77W5inX1jYMP0qbgGvjDStZ1XSZvN0-_uLdx_cciuoX4p-Nfs_k_wBqdsbtg3fnXVS4pouP7yLT8jelxDRa9-LTOr_abawfVdLWMR_bFjfzGHXYSNoP45rx2rOpX15qN495fXD3E8hyzuck10_wo8JXPirxPCrRH-zrVxJdyEcYByEHuf5V83Vm8xxl6cd2eDUm8di7wjufTvhWOSHw5psUuRItpEGz6hRmtTtTY1CqFHGKV2AUkkAAc5r9KglGCXY-9iuWKR5l-0Bqa2_hiDTA37y7myRn-BOf5la8J_Cuw-Kuu_274qneJs21t-5hx3x1P55rk8e1fnmc4lYjEyktlp9x8XmddVsQ2tloR4-tHNSY9qMe1eVY8-xHz6Uc-lSY9qMe1Fgsenfs_jF7qJ_65f8As1e3nrXiPwD_AOP3Uf8Atl_7NXttfo-Rf7nD5n22T_7tEoeIT_xL5B7V8ruPmP1r6o8RD_iXSfSvltgN54715PE-0Pn-h5uer4PmRYNGKkwPSjA9K-SPnbEeKMVJgelGB6UBYjwa2vBGqnRfFFlfk4RJAsnuh4P6Vk4o6VrRqSpzU47oulKVOakt0fWkTrJGsikFWGQR3pl5bQ3Vu9vcRLJFIpV0YZDA9Qa4b4NeIhquhLp9xJm6sxt5PLJ2P4dK78c1-k4etDE0lNbP-rH3lCrGvTUlszyHxP8ABDRruV59Fv5tOLc-SyeZED7fxD8zXI3XwM8Uq3-j6jpUi9i7SIfyCmvo3j0oIHpXDWyPB1XzONvTQ4qmUYWo7uNvTQ-d9N-BXiB5lGo6rp1vH3MAeRv1CivUvAnw60Dwpie2ia6vtuDczcsP90dFH0_Ou2wPSjHtWmGynC4aXNCOvd6mmHy3D4d80I6kNxBFcW8kEqho5FKsp6EEYIrw3U_gTdNqbnTtbiSzZiVE0TGRAe3HB_SveSBSbRnOK6MXgaGKS9rG9jXEYOjiUlUV7HP-CPDlt4W8P2-kWrGRY8lpGGC7E5Jrd9RT8UHHpXRTpxpxUYqyRvCChFRjokeOePvg6da12fVdH1GO0a5cyTQzISu89WBHTPXFdB8KvhxD4OeW8nu_tuoTLsMgTaiJ12qPr3r0PaPSjAxxXHDLMNCt7dR945YZfQhV9qo-8L3rgfit8P4fGsFvLHd_Y762yI5Cu5WU9VI_rXfUhFdVehTrwdOorpnRWowrQcJq6Z4_8O_g-2g65Dq-rajFdyW53QxQoQobsxJ5OK7zxh4R0XxXYrbapa7ymfKlU7ZEPsf6dK6Tj0pMeorClgMPRpOlGPuv5mVHBUKVP2cY6M8I1f4D3AZjpOvRsn8KXURz-a_4VjH4G-Lw3F5o23182T_4ivpDA9KXP0rhnw_gpO_Lb5nHLJsJJ35bfM8N8OfAoCZZNe1cOg-9DaoRu_4G39BXr-haNpuh6clhpdrHa28f3UQd_UnqT7mtIDg5xQenau7C5fQwv8KNvzOzD4Ojh1-7jb8wJHHFcD8X_FC6Nor6fbSf6bdqVAHVEPBNdL4u8QWfh7SHvbpgW6RR55duwr5v8Q6rd63q0uoXkm6SRvyHYV52dZisPT9lB-8_wRxZpjlRh7OPxP8ABGackknJJ55owak4oxXwp8k1cjoxUmB6UYHpQKxHijFSYHpRgelAWPSfgN_x_aj_ANsv_Zq9qbrXi3wIGL_UP-2f_s1e0nrX6JkX-5xPt8o_3aJR8Qn_AIl7j2NfL7KNx-tfUPiE40-TPpXzC6_MfrXk8S68nz_Q8vPPsfMj2ijaKfj60beK-TsfPDNoo2in4-tGPrRYBm0UbRTwvvS7aLBYv-G9YutC1eHULVjuQ_MvZl7g19GeHNas9c0qK-spAyuPmHdT3Br5jK4rf8F-Jr7w3qAmgJeByBLCTww_xr2sozJ4WXJP4X-HmerluPeHlyS-F_gfSXPpS8YrG8Na_p2u2a3NjKGyPnQn5kPoRWwCD0r7iFSNSKlF3TPrIyUleLuh1FIDS1oUFFFFABRRRQAUUUUAFFFFABRRSE0ALRSZFIWFACE85rH8Ua_YeH9Oa7vXUcfJHn5nPoKyPGvjfTdAjaGNhcXpztiVuB9f8K8R8Q6zqGuXrXeoTtIx6Ln5VHoBXiZlm8MMnCGsvyPLx2ZQoLlhrL8iTxh4ivvEmqPdXTFYxxFED8qD_GsXaKk2UbK-IqznVm5zd2z5OpKVSTlJ3bI9oo2in7KNvNZ2IGbRRtFPK4ox9aLAM2ijaKftpdnvRYD0X4F8X1-P-uf_ALNXtIzivGPggMX19_2z_wDZq9mFfoWSf7nD5n2mVf7tEz_EHNjJn-7XzQyZY_WvpbxB_wAeEg9q-bWX5jz3ryuI9qfzPNzz7HzIto70bKl20m2vlT54j2j1o2VIFOKMGgCPZSbKl20BfwoAj2j1o2Z6VLt96TafWgCzo-p3-kXi3djcPFIpycHg_X1r2n4c-Mh4iSS2uY1ivYV3MF6OvqK8Nwa7_wCCFs7-JLq5GdkVthvqx4H6GvZybFVYV404vR7o9XK8RUhWjTT0fQ9pX60GkXpTjX3R9agoopDQAtFRluaVWHpSuA-ikyKQmmAfQUUwuoGSwFUrzV9OtFLXN3BEB13OM_lUSnGOrZLlGOrZoZGOtIxyByK4rV_iPoFmrC3kku3HQRrgfma4jXfiRrN4GjslWyjPQry_5mvOxGb4ajpzXfkcVbMaFL7V35HrGua9pmjRF766SP0UHLH8K8s8YfEq9vw9to6G1gPBlP32-npXDXdxcXcxluZ3mkY5LOSTUW2vnMZnlaveNP3V-J4WKzarVvGGi_EjkLyuZJXZ3bkljkmk2j0qQrRg-leG23qzyrkYT1o2j1qQA0u33oERbR6UbKkwaApoAj2UbKk2-9Lt96AIto9aAo71Jt_GgL-FAHoHwSH-n33_AGz_APZq9jrx74KjF9e_9s__AGavYua-_wAk_wB0ifaZV_u8TP8AEPFhJ9K-cGQlj9a-j_EPOnyH2r52KnJx615fEW1P5nnZ39j5kGyjZU200bTXy9jwCHZRsqbaaNposBDso2VNtNG00WAh2UbKm2mjaadgsQlcDNe3_CvQ20nw6s06EXF4fNcHqq4-UH8P51wfwz8NNrWrC8uk_wBBtWDNkcSP2X8O9e2phVwD0r6jI8Dy3ry-X-Z9BlGE5f3svkPWhjxWVq-vaZpcZe8u4oyP4d2WP4VwXiL4mswaLSICvbzZBz-Ar2cRj6FBe_LXt1PUr4yjRXvM9C1jV7DSrcz3t0kSgcAnk_Qd68u8V_Ea-u2aDRwbaHp5h--3-FcbqV9e6nObi-uHmc92NVdpr5nG51Vre7S91fieBis1qVfdp6L8SydV1UyGT7fcbzyT5hqzB4k1-H7mq3IHpvNZu00bTXlLEVU7qT-889Vqid-Z_ebQ8XeJQONVuD_wKkbxb4kdcHVbj_vqsbaaNpqvrNf-d_ex_WKv8z-8uXGs6xcZE2o3Dg9cyGqDmRzl3Zj7nNP2mjaaylUnLdkOpKW7IdlGyptpo2ms7EEOyjZU200bTRYCHZRsqbaaNposBDso2VNtNG00WAh2UbKm2mjaaLAQ7KNlTbTQVJosFiHZRsqbaaNposFju_gyMX15x_zz_wDZq9fHQV5F8HOL67Hrs_8AZq9dFffZMv8AZIn1-Vf7vEzvEP8Ax4P9K-emXDH619C-IP8Ajwk-leAumHI968ziFaQ-Zw50vg-ZBijH1qbZRsr5ix4FiHH1oxU2yjZRYLEOKMfWptlGyiwWIcVLaRwNcotzI8cJb52QZbHt70uyjZTjo7jWjud3H4-tdLsI7HRNMCQxLtXzG_U-9YOq-NPEGoFla8aGM_wxDH61hbKNldtTMcRUXK5WXlodU8bXkrOWhHK8krl5Xd2PcnJpuKm2UbK4nrqzlbvuQY-tLiptlG2lYViHFGKm2UbKLBYhxRiptlGyiwWIcUYqbZRsosFiHH1oxU2z6UbKLBYhxRj61Nt-lG2iwWIcUYqbZRsosFiHFGKm2UbKLBYhxRiptlGyiwWIdtGPrU2yjbRYLEOPrRiptlG2iwWO2-EAxf3X_AP6161-FeT_AAkXF7dH_d_rXrOa-7yf_dIn1-Wf7vEz9dG6wkx6V4PeIUu5Vx0c_wA69-1ZN1q4x2rwvW08rXLmAjBJ3D6VzZ3Rc6Cmvss581pOdJSXQoYNGD6VLtPpRtPpXyNj5oiwfSjHtUu0-lG0-lOwEWD6UYPpUu0-lG0-lFgIse1G0-lS7T6UbT6UWAiwfSjBqXafSjBzRYCLBowalwfSjafSiwEWD6UYNS7T6UYNFgIsGjBqXafSjB9KLARYNGDUuD6UbT6UWAiwfSjBqXB9KNp9KLARYNGDUu0-lG0-lFgIse1GD6VLg-lG0-lFgIsH0owal2n0owfSiwEWPajBqXafSjafSiwEWD6UYNS4PpRtPpRYCLHtRg-lS4PpRg-lFgIsH0ox7VLtPpTXwiF24AGTQotuyGk5aI7n4VJiWZsYywr1JTxXnXwogJsxMwxvOa9E4FffYOj7KjGHZH2eGp8lOMOyEnXfGRXh_wAW7SbT75dThQkxn5lH8S9xXuZGRXI-P9FXUNNkXbnINbThGcXGWzNJRUk0zyOyniu7WO5gcPHIu5SKmxXCy6hP4M16S1vgx0qZ8sQCfJY_xD29a7q3liuIEngkWWJ1DI6nIYHoRXxONwUsPUa6dD5XFYWVGdnt0DFJin49qMH0risclhmKXFOwfSjB9KLDsM2ilxTsH0owfSiwWG4owKdg-lGD6UWDlG4o207B9KMH0osFhu2jbTsH0owfSiwWG4oxTsH0owfSiwco3FG2nYPpRg-lFgsNwKNtOwfSjB9KLBYbtowKdg-lGD6UWCw3FJin4PpRg-lFgsMxS4p2D6UYPpRYLDcUbadg-lGD6UWCw3FGKdg-lGD6UWCw3FGBTsH0pQCTTsKxGVrK1C4-1anDo1udzsQ8-P4V9Pxqt4y8TW-iQi1h2zalMP3MI5x_tN6L_Otz4NeGriaf-0L3dJPK2-R26k17mVYBzl7Sey28z18uwblJVJrRbHsfgex-yaZEuMYFdLVeyhWCFUUdBirNfUn0AVBcwiWJkIyKnooA8Z-LPgdNRtZHSIZwe1fP0Gp-Ifh_qDwiJrzSyxL2z8bfdD2Pt0r7dvbWK5iKuucivLfiD8PbbUopGSIEkHtWNWjCrFxmroipTjUjyyV0ed-FPGXh_wASRD7Beotzj5rWYhJVP-73-ozXQ4rxbxr8L7yyuHmto5EZTlWXIIPqDWHaeJviJ4c_cx373kKf8s7uPzf1PzfrXhV8kd70pfeePVyp3vTZ9DUmPavELf4z-I4BtvfDVpOR3ilaPP5hqn_4Xnejj_hDf_J8_wDxuuF5RiV9n8Ucjy6v_L-J7Tg-lJj2rxb_AIXpe_8AQm_-VA__ABuj_het7_0Jp_8AA8__ABul_ZOK_l_FB_Z9f-X8Ue04oxXi_wDwvO8_6E3_AMqH_wBrpP8Ahed5n_kTf_Kgf_jdH9lYn-X8UH9nV_5fxR7VRXi3_C87z_oTf_J8_wDxuk_4XpeD_mTP_Kgf_jdH9k4n-X8UH9nV_wCX8Ue04pce1eKf8L1vP-hN_wDKh_8Aa6UfHS9P_Mmn_wADz_8AG6P7JxX8v4oP7Pr_AMv4o9qx7UmPavFv-F6Xucf8Iaf_AAPP_wAboPx0vR_zJp_8Dz_8bo_snFfy_ig_s6v_AC_ij2rB9KMe1eK_8L0vf-hN_wDJ8_8AxulHx0vf-hN_8nz_APG6P7JxX8v4oP7Pr_y_ij2nB9KTFeL_APC873_oTv8AyfP_AMbpD8dLz_oTP_Kgf_jdH9lYr-X8UH9nV_5fxR7VScV4r_wvS8_6Ez_yfP8A8bpR8c7w_wDMmf8Ak-f_AI3R_ZOJ_l_FB_Z1f-X8Ue1Y9qMH0rxb_hed7_0Jv_k-f_jdIfjpej_mTf8AyoH_AON0f2Tiv5fxQf2dX_l_FHtWD6UY9q8W_wCF6Xv_AEJp_wDA8_8AxukPxzvc_wDIm5_7iB_-N0f2Tiv5fxQf2dX_AJfxR7TilwfSvFf-F6XnbwZ_5UD_APG6X_hel7_0Jv8A5Pn_AON0f2Tif5fxQf2dX_l_FHtGKMYrxZ_jhqcn-p8Ioh_2rwt_7IKz7v4p-O9RBjsbKxsAejJEXYfi2R-lXHKMQ3qrfMccurN6qx7pd3NvaW73F3PFBCgy0kjBVX6k15t4p-KETyPp3hOP7ZcHg3bL-6T_AHR_F-g-tcJB4f8AFXiq7WXWr67vCTwrsdo-i9B-VexfDf4UiJo5ZoP0r1MNk0Ie9Ud3-B30MrjH3qjuYvwv8D32qaj_AGlqbS3FxK255JOSxr6f8K6NFp1mihAMDniovC_h63023RVQDA9K6RQAMAYr2opJWR6qVlYAMcU6ikpjFooooAKjmiWRcMARUlFAHP6t4bsr5SHiUk-1cFr3wwsbosUhXJ9q9cxTSo7jNAHzpqHwbhLErCPyrNf4NLuyIB_3zX00YY2zlRSfZoh0WgD5k_4Uyv8Az7j8qP8AhTK_88B-VfTf2eL-4KPs8X9wUAfMv_Cml_54_pR_wphevkj8q-mvs8X9wUfZouu0UAfMn_CmVH_LEH8KP-FMr_zwH_fNfTf2eH-4KPs8X90UAfMn_Cml_wCeA_Kj_hTKj_liD-FfTf2eL-6KPs8X9wUAfMn_AAplf-eA_Kj_AIUyv_PAH8K-nPs0X90Uhtoh1UGgD5k_4Uyv_PEH8KP-FMr_AM8B-VfTf2eL-4KPs8X9wUAfMv8Awpof88B-VJ_wplf-eA_75r6b-zRf3B-VL9mi_uj8qAPmP_hTK_8APuPyo_4Uyv8Az7j8q-mzbRf3B-VAt4f7goA-ZP8AhTK_88R-VL_wplT1hH5V9NfZ4v7gpfs0X9wUAfMf_Cmh_wA8R-VH_CmVP_LAflX039ni_uCg28Q_gFAHzJ_wplf-fcflSj4MrnH2cflX019ni_uCj7PFn7goA-bbf4NRBhmAf9810Gj_AAjtYipaBfyr3LyI8_dFPCKOgoA4bQfAlhZbD5KggeldfZafBbKAiAY9KuACloAQLjjFOo70UAFFFFAH_9k";
	final static List<String> userList=new ArrayList<String>();//Arrays.asList(new String[]{"kadamba_nivas","sh1","library"});//,"entrance","obh_north_mess"});
	final static List<String> location=new ArrayList<String>();//Arrays.asList(new String[]{"west-iiith","center-iiith","center-iiith"});//,"center-iiith","north-iiith","south-iiith"});
	
	final static SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
	final static String startDate="2014-11-20 03:00:00",endDate="2014-12-03 03:30:00";
	final static List<Integer> possiblePeriods=Arrays.asList(new Integer[]{10,15,20,25,30});
	
	final static HashMap<String,List<String>> picMap=new HashMap<String,List<String>>();
	
	public static void build() throws Exception{
		final File file=new File("C:/Users/Ganesh/Desktop/iiit photos/");
		for(File folder:file.listFiles()){
			String user=folder.getName().split(" ")[0];
			userList.add(user);
			location.add(folder.getName().split(" ")[1]);
			List<String> set=new ArrayList<String>();
			for(final File f:folder.listFiles()){
				BufferedImage image=ImageIO.read(f);
				ByteArrayOutputStream baos = new ByteArrayOutputStream();
				ImageIO.write(image, "jpg", baos);
				byte[] res=baos.toByteArray();
				set.add(Base64.encodeBase64URLSafeString(res));
			}
			picMap.put(user,set);		
		}
	}
	
	public static void main(final String[] argv) throws Exception{
		build();
		pw=new PrintWriter(new File("out"));
		
		signUp();
		JSONParser parser=new JSONParser();
		Random rand=new Random();
		int min=0,max=possiblePeriods.size();
		
		HashMap<String,String> map=new LinkedHashMap<>();
		map.put("2014-09-23 08:00:00","2014-09-23 08:45:00");
		map.put("2014-09-27 18:00:00","2014-09-27 18:35:00");
		map.put("2014-10-11 11:05:00","2014-10-11 11:45:00");
		map.put("2014-10-19 15:30:00","2014-10-19 16:30:00");
		map.put("2014-11-03 11:05:00","2014-11-03 11:45:00");
		map.put("2014-11-06 15:30:00","2014-11-06 16:30:00");
		map.put("2014-11-21 22:15:00","2014-11-21 22:30:00");
		map.put("2014-11-28 01:10:00","2014-11-28 01:50:00");
		map.put("2014-11-29 03:45:00","2014-11-29 04:30:00");
		map.put("2014-11-30 08:00:00","2014-11-30 09:30:00");		
		
		for(Entry<String,String> entry:map.entrySet()){
			Date cur=sdf.parse(entry.getKey());
			Date end=sdf.parse(entry.getValue());
			int minute=(int)(end.getTime()-cur.getTime())/(1000*60);
			
			while(cur.getTime()<end.getTime()){
				Date endTime=new Date();
				endTime.setTime(cur.getTime()+(1000*60*minute)-1000);
				for(int userIndex=0;userIndex<userList.size();userIndex++){
					//create session
					String sessionInfo=postCall("http://localhost:8080/RestService/post/createSessionInfo","{\"userId\":\""+userList.get(userIndex)+"\",\"startTime\":\""+sdf.format(cur)+"\",\"endTime\":\""+sdf.format(endTime)+"\",\"location\":\""+location.get(userIndex)+"\"}");
					JSONObject obj = (JSONObject)parser.parse(sessionInfo);
					String sid=(String)obj.get("sessionId");
					Date c=new Date();
					c.setTime(cur.getTime());
					
					int val=possiblePeriods.get(rand.nextInt(possiblePeriods.size())+0);
					for(int i=0;i<(minute/val);i++){			
						min=0;
						max=picMap.get(userList.get(userIndex)).size()-1;
						int ind=rand.nextInt((max-min+1)+min);
						postCall("http://localhost:8080/RestService/post/imageInfo","{\"userId\":\""+userList.get(userIndex)+"\",\"sessionId\":\""+sid+"\",\"snapedAt\":\""+sdf.format(c)+"\",\"data\":\""+picMap.get(userList.get(userIndex)).get(ind)+"\"}");
						c.setTime(c.getTime()+1000*60*val);					
					}					
				}
				cur.setTime(cur.getTime()+1000*60*minute);
			}
		}
		
	}
	
	public static void signUp() throws Exception{
		for(String user:userList){	 
			String input = "{\"id\":\""+user+"\",\"name\":\""+user+"\",\"password\":\"678\",\"clickDelayInSeconds\":\"20\",\"uploadIntervalInSeconds\":\"20\"}";
			postCall("http://localhost:8080/RestService/post/signUpInfo",input);						
		}
	}
	
	public static String postCall(String urlStr,String input) throws Exception{
		pw.println(urlStr+"\t"+input);
		URL url = new URL(urlStr);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setDoOutput(true);
		conn.setRequestMethod("POST");
		conn.setRequestProperty("Content-Type", "application/json");
		OutputStream os = conn.getOutputStream();
		os.write(input.getBytes());
		os.flush();
 
		BufferedReader br = new BufferedReader(new InputStreamReader(
				(conn.getInputStream())));
 
		String output;
		//pw.println("Output from Server .... \n");
		StringBuffer buff=new StringBuffer();
		while ((output = br.readLine()) != null) {
			buff.append(output);
			//pw.println(output);
		}			
		
		conn.disconnect();
		return buff.toString();
	}
	
	static PrintWriter pw=null;

}
