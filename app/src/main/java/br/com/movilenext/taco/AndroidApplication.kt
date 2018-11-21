package br.com.movilenext.taco

import android.app.Activity
import android.app.Application
import br.com.movilenext.taco.core.di.ApplicationComponent
import br.com.movilenext.taco.core.di.ApplicationModule
import br.com.movilenext.taco.core.di.DaggerApplicationComponent
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import javax.inject.Inject

class AndroidApplication : Application(), HasActivityInjector {

    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Activity>

    private val appComponent: ApplicationComponent by lazy {
        DaggerApplicationComponent.builder()
            .application(this)
            .appModule(ApplicationModule(this))
            .build()
    }

    override fun onCreate() {
        super.onCreate()

        appComponent.inject(this)
    }

    override fun activityInjector(): AndroidInjector<Activity> = dispatchingAndroidInjector
}