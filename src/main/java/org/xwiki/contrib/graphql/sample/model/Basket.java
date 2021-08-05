/*
 * See the NOTICE file distributed with this work for additional
 * information regarding copyright ownership.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */
package org.xwiki.contrib.graphql.sample.model;

import java.util.ArrayList;
import java.util.List;

/**
 * @version $Id$
 */
public class Basket
{
    private List<Fruit> fruits = new ArrayList<>();

    public void addFruit(Fruit fruit)
    {
        fruits.add(fruit);
    }

    public List<Fruit> getFruits()
    {
        return fruits;
    }

    public Fruit removeFruit(int index)
    {
        return fruits.remove(index);
    }
}
