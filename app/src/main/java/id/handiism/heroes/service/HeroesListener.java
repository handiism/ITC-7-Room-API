package id.handiism.heroes.service;

import id.handiism.heroes.database.AppDatabase;

public interface HeroesListener<T> {
    void onSuccess(T items);

    void onFailed(String message);
}
