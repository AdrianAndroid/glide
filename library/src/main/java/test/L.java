package test;


import android.text.TextUtils;
import android.util.Log;

/**
 * flannery
 */
public class L {

  private static final String DEFAULT_TAG = "CJT";

  public static void i(String tag, String msg) {
//        if (DEBUG)
    Log.i(tag, msg);
  }

  public static void v(String tag, String msg) {
    if (true) { Log.v(tag, msg); }
  }

  public static void d(String tag, String msg) {
    if (true) { Log.d(tag, msg); }
  }

  public static void e(String tag, String msg) {
    if (true) { Log.e(tag, msg); }
  }

  public static void i(String msg) {
    i(DEFAULT_TAG, msg);
  }

  public static void v(String msg) {
    v(DEFAULT_TAG, msg);
  }

  public static void d(String msg) {
    d(DEFAULT_TAG, msg);
  }

  public static void e(String msg) {
    e(DEFAULT_TAG, msg);
  }


  /**
   * 只能在本类使用，可以打印出行数
   *
   * @param o
   */
  public static void m3(Object... o) {
    if (true) {
      StackTraceElement stackTraceElement = Thread.currentThread().getStackTrace()[3];
//            String fileName = stackTraceElement.getFileName();
//            String className = stackTraceElement.getClassName();
//            String methodName = stackTraceElement.getMethodName();
//            int lineNumber = stackTraceElement.getLineNumber();
//
//            StringBuilder sb = new StringBuilder();
//            sb.append(methodName).append("(").append(fileName).append(":").append(lineNumber).append(")");
//            for (Object value : o) {
//                sb.append(value).append(",");
//            }
//            //Log.i(fileName, methodName+"("+fileName+":"+lineNumber+")");
//            Log.i(fileName, sb.toString());
      printLogString(stackTraceElement, null, o);
    }
  }

  // 打印log
  public static void printLogString(StackTraceElement stackTraceElement, String otherTag,
      Object... o) {
    StringBuilder sb = new StringBuilder();
    sb.append("[[").append(Thread.currentThread().getName()).append("]]");

    String fileName = "L"; //防止为空
    if (stackTraceElement != null) {
      fileName = stackTraceElement.getFileName();
      String className = stackTraceElement.getClassName();
      String methodName = stackTraceElement.getMethodName();
      int lineNumber = stackTraceElement.getLineNumber();

      sb.append(methodName).append("(").append(fileName).append(":").append(lineNumber).append(")");
    }

    if (!TextUtils.isEmpty(otherTag)) {
      sb.append("-->").append(otherTag).append(",");
    }

    for (Object value : o) {
      sb.append(value).append(",");
    }
    //Log.i(fileName, methodName+"("+fileName+":"+lineNumber+")");
    Log.i(fileName, sb.toString());
  }

  /**
   * 第一版测试用，可以去掉
   */
  public static void m2() {
    if (true) {
      StackTraceElement stackTraceElement = Thread.currentThread().getStackTrace()[3];
      String fileName = stackTraceElement.getFileName();
      String className = stackTraceElement.getClassName();
      String methodName = stackTraceElement.getMethodName();
      int lineNumber = stackTraceElement.getLineNumber();
      Log.i(fileName, methodName + "(" + fileName + ":" + lineNumber + ")");
    }
  }

  public static void m(Class<?> aClass, String otherTag, Object... o) {
    if (true) {
      if (aClass == null) {
        printLogString(null, otherTag, o);
      } else {
        StackTraceElement classStackTraceElement = findClassStackTraceElement(aClass);
        if (TextUtils.isEmpty(otherTag)) {
          otherTag = aClass.getName();
        }
        printLogString(classStackTraceElement, otherTag, o);
      }
    }
  }

  public static void loopStackTrace(String tag) {
    if (true) {
      int count = 0;
      Log.i(tag, "vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv");
      for (StackTraceElement stackTraceElement : Thread.currentThread().getStackTrace()) {
        printLogString(stackTraceElement, tag);
        if (count++ > 10) {
          break;
        }
      }
      Log.i(tag, "^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
    }
  }

  /**
   * 自己提供类名
   */
  public static void m(Class<?> aClass, Object... o) {
    m(aClass, null, o);
  }

  public static StackTraceElement findClassStackTraceElement(Class<?> aClass) {
    if (true)
    //Thread.currentThread().getStackTrace()[4].getClassName()
    //cn.kuwo.pp.ui.discover.FriendMatchingDialog
    //aClass.getCanonicalName()
    //cn.kuwo.pp.ui.discover.FriendMatchingDialog
    {
      for (StackTraceElement stackTraceElement : Thread.currentThread().getStackTrace()) {
        if (stackTraceElement != null && aClass != null) {
          String className = stackTraceElement.getClassName();
          String canonicalName = aClass.getCanonicalName();
          if (!TextUtils.isEmpty(className)
              && !TextUtils.isEmpty(canonicalName)
              && className.startsWith(canonicalName)) {
            return stackTraceElement;
          }
        }
      }
    }
    return null;
  }


  public static void L(Class<?> aClass, String... msg) {
    String tag;
    if (aClass != null) {
      tag = aClass.getSimpleName();
    } else {
      tag = "L";
    }
    if (msg.length == 1) {
      Log.d(aClass.getSimpleName(), msg[0]);
    } else if (msg.length > 1) {
      StringBuilder sb = new StringBuilder();
      for (String s : msg) {
        sb.append(s).append(",");
      }
      Log.d(aClass.getSimpleName(), sb.toString());
    }
  }

}
