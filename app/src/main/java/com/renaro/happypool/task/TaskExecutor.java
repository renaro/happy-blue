package com.renaro.happypool.task;

import android.support.annotation.NonNull;

public interface TaskExecutor {

    <T> void async(@NonNull final AppTask<T> task);
}
