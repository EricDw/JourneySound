// Generated code from Butter Knife. Do not modify!
package com.publicmethod.owner.JourneySound;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.ViewBinder;

public class MainActivity$$ViewBinder<T extends com.publicmethod.owner.JourneySound.MainActivity> implements ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131492966, "field 'mCollapsingToolbar'");
    target.mCollapsingToolbar = finder.castView(view, 2131492966, "field 'mCollapsingToolbar'");
    view = finder.findRequiredView(source, 2131492969, "field 'mFab'");
    target.mFab = finder.castView(view, 2131492969, "field 'mFab'");
  }

  @Override public void unbind(T target) {
    target.mCollapsingToolbar = null;
    target.mFab = null;
  }
}
