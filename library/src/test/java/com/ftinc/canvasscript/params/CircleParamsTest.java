/*
 * Copyright (c) 2017 52inc
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.ftinc.canvasscript.params;


import android.graphics.Canvas;
import android.graphics.Paint;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;


@RunWith(MockitoJUnitRunner.class)
public class CircleParamsTest {

    private static final float CENTER_X = 10f;
    private static final float CENTER_Y = 10f;
    private static final float RADIUS = 5f;

    @Mock Paint paint;


    @Test
    public void shouldDrawCircleOnCanvas() {
        Canvas canvas = mock(Canvas.class);
        CircleParams params = new CircleParams(CENTER_X, CENTER_Y, RADIUS, paint);

        int saveCount = params.draw(canvas);

        verify(canvas).drawCircle(CENTER_X, CENTER_Y, RADIUS, paint);
        assertThat(saveCount, is(CanvasParams.NO_SAVE));
    }
}