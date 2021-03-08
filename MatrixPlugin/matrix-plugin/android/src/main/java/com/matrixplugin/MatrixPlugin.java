package com.matrixplugin;

import com.getcapacitor.JSArray;
import com.getcapacitor.JSObject;
import com.getcapacitor.NativePlugin;
import com.getcapacitor.Plugin;
import com.getcapacitor.PluginCall;
import com.getcapacitor.PluginMethod;

import org.json.JSONException;

import com.example.nativecpp.Matrixlib;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

@NativePlugin
public class MatrixPlugin extends Plugin {


    @PluginMethod
    public void echo(PluginCall call) {
        String value = call.getString("value");

        JSObject ret = new JSObject();
        ret.put("value", value);
        call.success(ret);
    }

    @PluginMethod
    public void Mult(PluginCall call) {
        System.out.println(call.getData());
        JSArray a = call.getArray("a");
        JSArray b = call.getArray("b");
//        JSArray aa = new JSArray();
//        aa.put(1);
//        System.out.println(call.getArray("a", aa));
        Matrixlib obj = new Matrixlib();
//        System.out.println(Arrays.toString(cast(a)));
        StringTokenizer st = new StringTokenizer(obj.Multiply(cast(a), cast(b)));
        int[] res = new int[9];
        for (int i = 0; i < 9; i++)
            res[i] = Integer.parseInt(st.nextToken());

        JSObject ret = new JSObject();
//        JSArray a1 = new JSArray();

        ret.put("value", convert(res));
//        ret.put("value", convert(sum(cast(a), cast(b))));
        call.success(ret);
    }

    static int[] cast(JSArray a) {
        int[] res = new int[a.length()];

        for (int i = 0; i < a.length(); i++) {
            try {
                res[i] = (a.getInt(i));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return res;
    }

    static ArrayList<Integer> sum(ArrayList<Integer> a, ArrayList<Integer> b) {
        ArrayList<Integer> res = new ArrayList<>();

        for (int i = 0; i < a.size(); i++) {
            res.add(a.get(i) + b.get(i));
        }
        return res;
    }

    static JSArray convert(int[] a) {
        JSArray res = new JSArray();

        for (int i = 0; i < a.length; i++) {
            res.put(a[i]);
        }
        return res;
    }
}
