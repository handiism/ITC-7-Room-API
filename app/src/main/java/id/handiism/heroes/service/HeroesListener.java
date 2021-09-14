package id.handiism.heroes.service;

public interface HeroesListener<T> {
    void onSuccess(T items);

    void onFailed(String message);
}
