import java.util.List;

import rx.Observable;
import rx.Observer;

/**
 * Created by sinyuk on 2016/12/24.
 */

public class EmptyTest {
    public static void main(String[] args) {
        test();
    }

    private static void test() {
        Observer<List<String>> observer = new Observer<List<String>>() {
            @Override
            public void onCompleted() {
                System.out.println("onCompleted");
            }

            @Override
            public void onError(Throwable e) {
                e.printStackTrace();
            }

            @Override
            public void onNext(List<String> strings) {
                if (strings.isEmpty()) {
                    System.out.println("Empty");
                } else {
                    System.out.println(strings.toString());
                }
            }
        };

        Observable.just(null)
                .subscribe(new Observer<Object>() {
                    @Override
                    public void onCompleted() {
                        System.out.println("onCompleted");
                    }

                    @Override
                    public void onError(Throwable e) {
                        System.out.println("onError");
                    }

                    @Override
                    public void onNext(Object o) {
                        System.out.println("onNext");
                    }
                });
    }
}
