package nestel.pcphonecommunicator;

import android.content.Context;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

/**
 * Created by nestel on 6.6.2016.
 */
public class WebApi
{
    //todo: replace with real url
    public static String URL = "http://ppc.gabrielkerekes.eu";

    private Context context;

    public WebApi(Context context)
    {
        this.context = context;
    }

    //todo: remake with request types as enum with appropriate urls
    public void doRequest(String path)
    {
        // Instantiate the RequestQueue.
        RequestQueue queue = Volley.newRequestQueue(context);
        String url = URL + path;

        Log.d("NSTL", url);

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>()
                {
                    @Override
                    public void onResponse(String response)
                    {
                        Log.d("NSTL", "response: " + response);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("NSTL", "ERROR: " + error);
            }
        });

        // Add the request to the RequestQueue.
        queue.add(stringRequest);
    }
}
