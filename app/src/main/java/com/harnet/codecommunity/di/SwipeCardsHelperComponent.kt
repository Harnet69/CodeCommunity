package com.harnet.codecommunity.di

import com.harnet.codecommunity.view.TechsChooserFragment
import dagger.Component

@Component
interface SwipeCardsHelperComponent {
    fun inject(techsChooserFragment: TechsChooserFragment)
}